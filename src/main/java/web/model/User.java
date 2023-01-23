package web.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    @Size(min = 2, max = 30, message = "Name mustbe longer than30 and shorter than 2 symbols")
    @NotEmpty(message = "Name should not be empty")
    private String name;
    @Size(min = 2, max = 30, message = "Surname must be longer than 30 and shorter than 2 symbols")
    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;
    @Min(value = 8, message = "User must be at least 8 years old.")
    @Max(value = 120, message = "User must be under 120 years.")
    @Column(name = "age")
    private int age;

    @Column(name = "numberPhone")
    private long numberPhone;

    @Column(name = "passport")
    private long passport;

    public User() {
    }

    public User(long id, String name, String surname, String email, int age, long numberPhone, long passport) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.numberPhone = numberPhone;
        this.passport = passport;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(long numberPhone) {
        this.numberPhone = numberPhone;
    }

    public long getPassport() {
        return passport;
    }

    public void setPassport(long passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", numberPhone=" + numberPhone +
                ", passport=" + passport +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && numberPhone == user.numberPhone && passport == user.passport && Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, age, numberPhone, passport);
    }
}
