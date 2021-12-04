package hiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")

public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "car_id")
   private Car Car;

   
   public User(String firstName, String lastName, String email,Car car) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.Car=car;
   }

   public User() {

   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public hiber.model.Car getCar() {
      return Car;
   }

   public void setCar(hiber.model.Car car) {
      Car = car;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      User user = (User) o;
      return firstName.equals(user.firstName) && lastName.equals(user.lastName) && email.equals(user.email) && Car.equals(user.Car);
   }

   @Override
   public int hashCode() {
      return Objects.hash(firstName, lastName, email, Car);
   }

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", email='" + email + '\'' +
              ", Car=" + Car +
              '}';
   }
}
