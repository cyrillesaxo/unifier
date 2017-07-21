package io.swagger.model;

import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonProperty;

import info.archinnov.achilles.annotations.ClusteringColumn;
import info.archinnov.achilles.annotations.Column;
import info.archinnov.achilles.annotations.PartitionKey;
import info.archinnov.achilles.annotations.Table;
import io.swagger.annotations.ApiModelProperty;

/**
 * BillingLastPayment
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-07-06T13:50:42.619-04:00")

@Table(table="last_payment")
public class LastPayment   {

  @Column("customer_id")
  @PartitionKey
  @JsonProperty("customer_id")
  private String customerId = null;
	  
  @Column("date")	
  @ClusteringColumn(1)
  @JsonProperty("date")
  private String date = null;

  @Column("amount")
  @ClusteringColumn(2)
  @JsonProperty("amount")
  private String amount = null;

  
  public String getCustomerId() {
	return customerId;
  }

 public void setCustomerId(String customerId) {
	this.customerId = customerId;
 }

  public LastPayment date(String date) {
    this.date = date;
    return this;
  }

   /**
   * Get date
   * @return date
  **/
  @ApiModelProperty(value = "")


  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public LastPayment amount(String amount) {
    this.amount = amount;
    return this;
  }

   /**
   * Get amount
   * @return amount
  **/
  @ApiModelProperty(value = "")

  @Valid

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }


  @Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	LastPayment other = (LastPayment) obj;
	if (amount == null) {
		if (other.amount != null)
			return false;
	} else if (!amount.equals(other.amount))
		return false;
	if (customerId == null) {
		if (other.customerId != null)
			return false;
	} else if (!customerId.equals(other.customerId))
		return false;
	if (date == null) {
		if (other.date != null)
			return false;
	} else if (!date.equals(other.date))
		return false;
	return true;
}

  @Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((amount == null) ? 0 : amount.hashCode());
	result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
	result = prime * result + ((date == null) ? 0 : date.hashCode());
	return result;
}

  @Override
public String toString() {
	return "LastPayment [customerId=" + customerId + ", date=" + date + ", amount=" + amount + "]";
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

