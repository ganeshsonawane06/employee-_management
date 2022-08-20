package com.employee.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long employeeId;	
	@Column(nullable = true, unique = true)
	private String userName;	
	@Column(nullable = true)
	private String password;	
	@Column(nullable = false)
	private String firstName;	
	@Column(nullable = true)
	private String middleName;	
	@Column(nullable = true)
	private String lastName;	
	@Column(nullable = false)
	private String mobileNumber;
	private String gender;	
	@Column(nullable = true)
	private String email;
	@Column(nullable = true)
	private String city;
	@Column(nullable = true)
	private String address;	
	@Column(nullable = false)
	private String createddtm = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());	
	@Column(nullable = false)
	private String status;	
	@Column(nullable = false)
	private String department;	
	@OneToOne(targetEntity = Country.class, cascade = CascadeType.MERGE)
	private Country country;
	@Column(nullable = true)
	private String createdBy;
	@Column(nullable = false)
	private String updateBy;

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCreateddtm() {
		return createddtm;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", userName=" + userName + ", password=" + password
				+ ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", mobileNumber=" + mobileNumber + ", gender=" + gender + ", email=" + email + ", city=" + city
				+ ", address=" + address + ", createddtm=" + createddtm + ", status=" + status + ", department="
				+ department + ", country=" + country + ", createdBy=" + createdBy + ", updateBy=" + updateBy + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, city, country, createdBy, createddtm, department, email, employeeId, firstName,
				gender, lastName, middleName, mobileNumber, password, status, updateBy, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(address, other.address) && Objects.equals(city, other.city)
				&& Objects.equals(country, other.country) && Objects.equals(createdBy, other.createdBy)
				&& Objects.equals(createddtm, other.createddtm) && Objects.equals(department, other.department)
				&& Objects.equals(email, other.email) && employeeId == other.employeeId
				&& Objects.equals(firstName, other.firstName) && Objects.equals(gender, other.gender)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(middleName, other.middleName)
				&& mobileNumber == other.mobileNumber && Objects.equals(password, other.password)
				&& Objects.equals(status, other.status) && Objects.equals(updateBy, other.updateBy)
				&& Objects.equals(userName, other.userName);
	}

}
