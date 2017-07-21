package io.swagger.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import info.archinnov.achilles.annotations.ClusteringColumn;
import info.archinnov.achilles.annotations.Column;
import info.archinnov.achilles.annotations.DSE_Search;
import info.archinnov.achilles.annotations.Frozen;
import info.archinnov.achilles.annotations.PartitionKey;
import info.archinnov.achilles.annotations.Table;
import io.swagger.annotations.ApiModelProperty;

/**
 * Customer
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-07-06T15:59:15.554-04:00")

@Table(table="Customer")
public class Customer   {
  @Column
  @PartitionKey
  @JsonProperty("customer_id")
  private String customer_id = null;	

  @Column("faid")
  @ClusteringColumn(1)
  @JsonProperty("faid")
  private String faid = null;
  
  //@DSE_Search
  @Column("first_name")	
  @JsonProperty("first_name")
  private String firstName = null;

  //@DSE_Search(fullTextSearchEnabled = true)
  @Column("last_name")
  @ClusteringColumn(2)
  @JsonProperty("last_name")
  private String lastName = null;

  @Column("primary_contact_number")
  @JsonProperty("primary_contact_number")
  private String primaryContactNumber = null;

  @Column("address")
  @Frozen
  @JsonProperty("address")
  private Address address = null;

  @Column("account_status")
  @JsonProperty("account_status")
  private String accountStatus = null;

  @Column("credit_class")
  @JsonProperty("credit_class")
  private String creditClass = null;

  @Column("approved_lines")
  @JsonProperty("approved_lines")
  private String approvedLines = null;

  @Column("plan")
  @JsonProperty("plan")
  private String plan = null;

  public Customer firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

   /**
   * Get firstName
   * @return firstName
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Customer lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

   /**
   * Get lastName
   * @return lastName
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


public Customer primaryContactNumber(String primaryContactNumber) {
    this.primaryContactNumber = primaryContactNumber;
    return this;
  }

   /**
   * Get primaryContactNumber
   * @return primaryContactNumber
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getPrimaryContactNumber() {
    return primaryContactNumber;
  }

  public void setPrimaryContactNumber(String primaryContactNumber) {
    this.primaryContactNumber = primaryContactNumber;
  }


   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid


  public Customer address(Address address) {
    this.address = address;
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Customer accountStatus(String accountStatus) {
    this.accountStatus = accountStatus;
    return this;
  }

   /**
   * Get accountStatus
   * @return accountStatus
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getAccountStatus() {
    return accountStatus;
  }

  public void setAccountStatus(String accountStatus) {
    this.accountStatus = accountStatus;
  }

  public Customer creditClass(String creditClass) {
    this.creditClass = creditClass;
    return this;
  }

   /**
   * Get creditClass
   * @return creditClass
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getCreditClass() {
    return creditClass;
  }

  public void setCreditClass(String creditClass) {
    this.creditClass = creditClass;
  }

  public Customer approvedLines(String approvedLines) {
    this.approvedLines = approvedLines;
    return this;
  }

   /**
   * Get approvedLines
   * @return approvedLines
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public String getApprovedLines() {
    return approvedLines;
  }

  public void setApprovedLines(String approvedLines) {
    this.approvedLines = approvedLines;
  }

  public Customer plan(String plan) {
    this.plan = plan;
    return this;
  }

   /**
   * Get plan
   * @return plan
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getPlan() {
    return plan;
  }

  public void setPlan(String plan) {
    this.plan = plan;
  }

  public String getCustomer_id() {
	return customer_id;
}

public void setCustomer_id(String customer_id) {
	this.customer_id = customer_id;
}

public String  getFaid() {
	return faid;
}

public void setFaid(String faid) {
	this.faid = faid;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Customer other = (Customer) obj;
	if (accountStatus == null) {
		if (other.accountStatus != null)
			return false;
	} else if (!accountStatus.equals(other.accountStatus))
		return false;
	if (address == null) {
		if (other.address != null)
			return false;
	} else if (!address.equals(other.address))
		return false;
	if (approvedLines == null) {
		if (other.approvedLines != null)
			return false;
	} else if (!approvedLines.equals(other.approvedLines))
		return false;
	if (creditClass == null) {
		if (other.creditClass != null)
			return false;
	} else if (!creditClass.equals(other.creditClass))
		return false;
	if (customer_id == null) {
		if (other.customer_id != null)
			return false;
	} else if (!customer_id.equals(other.customer_id))
		return false;
	if (faid == null) {
		if (other.faid != null)
			return false;
	} else if (!faid.equals(other.faid))
		return false;
	if (firstName == null) {
		if (other.firstName != null)
			return false;
	} else if (!firstName.equals(other.firstName))
		return false;
	if (lastName == null) {
		if (other.lastName != null)
			return false;
	} else if (!lastName.equals(other.lastName))
		return false;
	if (plan == null) {
		if (other.plan != null)
			return false;
	} else if (!plan.equals(other.plan))
		return false;
	if (primaryContactNumber == null) {
		if (other.primaryContactNumber != null)
			return false;
	} else if (!primaryContactNumber.equals(other.primaryContactNumber))
		return false;
	return true;
}

  @Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((accountStatus == null) ? 0 : accountStatus.hashCode());
	result = prime * result + ((address == null) ? 0 : address.hashCode());
	result = prime * result + ((approvedLines == null) ? 0 : approvedLines.hashCode());
	result = prime * result + ((creditClass == null) ? 0 : creditClass.hashCode());
	result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
	result = prime * result + ((faid == null) ? 0 : faid.hashCode());
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
	result = prime * result + ((plan == null) ? 0 : plan.hashCode());
	result = prime * result + ((primaryContactNumber == null) ? 0 : primaryContactNumber.hashCode());
	return result;
}

  @Override
public String toString() {
	return "Customer [customer_id=" + customer_id + ", faid=" + faid + ", firstName=" + firstName + ", lastName="
			+ lastName + ", primaryContactNumber=" + primaryContactNumber + ", address=" + address + ", accountStatus="
			+ accountStatus + ", creditClass=" + creditClass + ", approvedLines=" + approvedLines + ", plan=" + plan
			+ "]";
}

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

