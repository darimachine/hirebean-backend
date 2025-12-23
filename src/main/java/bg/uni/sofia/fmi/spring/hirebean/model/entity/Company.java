package bg.uni.sofia.fmi.spring.hirebean.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company extends BaseEntity {

  @Column(nullable = false, unique = true)
  private String name;

  @Column(columnDefinition = "TEXT")
  private String description;

  private String websiteUrl;

  private String logoUrl; // link to file

  private String location;

  @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
  private List<JobOffer> jobOffers;

  // Recruiters
  @OneToMany(mappedBy = "company")
  private List<User> employees;
}
