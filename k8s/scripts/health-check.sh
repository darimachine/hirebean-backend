#!/bin/bash

echo "Waiting for Pods to be ready.."
kubectl wait --namespace hirebean --for=condition=ready pod --all --timeout=180s

echo "---- PODS STATUS ------"
kubectl get pods -n hirebean

# Giving spring boot moment to start
echo "Sleeping for 30s for spring boot..."
sleep 30

echo "----- Connection Test (retrying 10 times) ------"
kubectl run curl-test --image=curlimages/curl -n hirebean --restart=Never --command -- /bin/sh -c '
  for i in $(seq 1 10); do
    echo "Attempt $i: Connecting to backend..."
    if curl -v --fail http://hirebean-backend-service:80/api/companies; then
      echo "Success!"
      exit 0
    fi
    sleep 5
  done
  exit 1'

# Wait for result
kubectl wait --for=condition=ready pod/curl-test -n hirebean --timeout=60s || true
kubectl logs curl-test -n hirebean