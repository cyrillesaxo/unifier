package io.swagger.model;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import info.archinnov.achilles.annotations.ClusteringColumn;
import info.archinnov.achilles.annotations.Column;
import info.archinnov.achilles.annotations.PartitionKey;
import info.archinnov.achilles.annotations.Table;
import io.swagger.annotations.ApiModelProperty;

/**
 * Equipment
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-07-06T13:50:52.490-04:00")

@Table(table="Equipment")
public class Equipment   {

  @Column("customer_id")
  @PartitionKey
  @JsonProperty("customer_id")
  private String customerId = null;

  @Column("mdn")
  @JsonProperty("mdn")
  private String mdn = null;

  @Column("device_description")
  @JsonProperty("device_description")
  private String deviceDescription = null;

  @Column("first_name")
  @ClusteringColumn(2)
  @JsonProperty("first_name")
  private String firstName = null;

  @Column("last_name")
  @ClusteringColumn(1)
  @JsonProperty("last_name")
  private String lastName = null;

  @Column("role")
  @JsonProperty("role")
  private String role = null;

  @Column("pin")
  @JsonProperty("pin")
  private String pin = null;

  @Column("ric_active_indicator")
  @JsonProperty("ric_active_indicator")
  private Boolean ricActiveIndicator = null;

  @Column("ric_start_date")
  @JsonProperty("ric_start_date")
  private String ricStartDate = null;

  @Column("ric_end_date")
  @JsonProperty("ric_end_date")
  private String ricEndDate = null;

  @Column("ric_monthly_fee")
  @JsonProperty("ric_monthly_fee")
  private String ricMonthlyFee = null;

  @Column("ric_balance")
  @JsonProperty("ric_balance")
  private String ricBalance = null;

  @Column("protection_plan_charges")
  @JsonProperty("protection_plan_charges")
  private String protectionPlanCharges = null;

  @Column("upgrade_eligiblity_date")
  @JsonProperty("upgrade_eligiblity_date")
  private String upgradeEligiblityDate = null;

  @Column("devfin_meid")
  @JsonProperty("devfin_meid")
  private String devfinMeid = null;

  @Column("pending_orders")
  @JsonProperty("pending_orders")
  private Boolean pendingOrders = null;

  @Column("eligible_installment_subsidy")
  @JsonProperty("eligible_installment_subsidy")
  private Boolean eligibleInstallmentSubsidy = null;

  @Column("eu")
  @JsonProperty("eu")
  private String eu = null;

  @Column("ric_esn_active_indicator")
  @JsonProperty("ric_esn_active_indicator")
  private Boolean ricEsnActiveIndicator = null;

  @Column("devfin_credit_limit")
  @JsonProperty("devfin_credit_limit")
  private String devfinCreditLimit = null;

  @Column("last_credit_evaulation")
  @JsonProperty("last_credit_evaulation")
  private String lastCreditEvaulation = null;

  @Column("devfin_credit_limit_available")
  @JsonProperty("devfin_credit_limit_available")
  private String devfinCreditLimitAvailable = null;

  public Equipment customerId(String customerId) {
    this.customerId = customerId;
    return this;
  }

   /**
   * Get customerId
   * @return customerId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public Equipment mdn(String mdn) {
    this.mdn = mdn;
    return this;
  }

   /**
   * Get mdn
   * @return mdn
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getMdn() {
    return mdn;
  }

  public void setMdn(String mdn) {
    this.mdn = mdn;
  }

  public Equipment deviceDescription(String deviceDescription) {
    this.deviceDescription = deviceDescription;
    return this;
  }

   /**
   * Get deviceDescription
   * @return deviceDescription
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getDeviceDescription() {
    return deviceDescription;
  }

  public void setDeviceDescription(String deviceDescription) {
    this.deviceDescription = deviceDescription;
  }

  public Equipment firstName(String firstName) {
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

  public Equipment lastName(String lastName) {
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

  public Equipment role(String role) {
    this.role = role;
    return this;
  }

   /**
   * Get role
   * @return role
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public Equipment pin(String pin) {
    this.pin = pin;
    return this;
  }

   /**
   * Get pin
   * @return pin
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public String getPin() {
    return pin;
  }

  public void setPin(String pin) {
    this.pin = pin;
  }

  public Equipment ricActiveIndicator(Boolean ricActiveIndicator) {
    this.ricActiveIndicator = ricActiveIndicator;
    return this;
  }

   /**
   * Get ricActiveIndicator
   * @return ricActiveIndicator
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Boolean getRicActiveIndicator() {
    return ricActiveIndicator;
  }

  public void setRicActiveIndicator(Boolean ricActiveIndicator) {
    this.ricActiveIndicator = ricActiveIndicator;
  }

  public Equipment ricStartDate(String ricStartDate) {
    this.ricStartDate = ricStartDate;
    return this;
  }

   /**
   * Get ricStartDate
   * @return ricStartDate
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getRicStartDate() {
    return ricStartDate;
  }

  public void setRicStartDate(String ricStartDate) {
    this.ricStartDate = ricStartDate;
  }

  public Equipment ricEndDate(String ricEndDate) {
    this.ricEndDate = ricEndDate;
    return this;
  }

   /**
   * Get ricEndDate
   * @return ricEndDate
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getRicEndDate() {
    return ricEndDate;
  }

  public void setRicEndDate(String ricEndDate) {
    this.ricEndDate = ricEndDate;
  }

  public Equipment ricMonthlyFee(String ricMonthlyFee) {
    this.ricMonthlyFee = ricMonthlyFee;
    return this;
  }

   /**
   * Get ricMonthlyFee
   * @return ricMonthlyFee
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public String getRicMonthlyFee() {
    return ricMonthlyFee;
  }

  public void setRicMonthlyFee(String ricMonthlyFee) {
    this.ricMonthlyFee = ricMonthlyFee;
  }

  public Equipment ricBalance(String ricBalance) {
    this.ricBalance = ricBalance;
    return this;
  }

   /**
   * Get ricBalance
   * @return ricBalance
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public String getRicBalance() {
    return ricBalance;
  }

  public void setRicBalance(String ricBalance) {
    this.ricBalance = ricBalance;
  }

  public Equipment protectionPlanCharges(String protectionPlanCharges) {
    this.protectionPlanCharges = protectionPlanCharges;
    return this;
  }

   /**
   * Get protectionPlanCharges
   * @return protectionPlanCharges
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public String getProtectionPlanCharges() {
    return protectionPlanCharges;
  }

  public void setProtectionPlanCharges(String protectionPlanCharges) {
    this.protectionPlanCharges = protectionPlanCharges;
  }

  public Equipment upgradeEligiblityDate(String upgradeEligiblityDate) {
    this.upgradeEligiblityDate = upgradeEligiblityDate;
    return this;
  }

   /**
   * Get upgradeEligiblityDate
   * @return upgradeEligiblityDate
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getUpgradeEligiblityDate() {
    return upgradeEligiblityDate;
  }

  public void setUpgradeEligiblityDate(String upgradeEligiblityDate) {
    this.upgradeEligiblityDate = upgradeEligiblityDate;
  }

  public Equipment devfinMeid(String devfinMeid) {
    this.devfinMeid = devfinMeid;
    return this;
  }

   /**
   * Get devfinMeid
   * @return devfinMeid
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getDevfinMeid() {
    return devfinMeid;
  }

  public void setDevfinMeid(String devfinMeid) {
    this.devfinMeid = devfinMeid;
  }

  public Equipment pendingOrders(Boolean pendingOrders) {
    this.pendingOrders = pendingOrders;
    return this;
  }

   /**
   * Get pendingOrders
   * @return pendingOrders
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Boolean getPendingOrders() {
    return pendingOrders;
  }

  public void setPendingOrders(Boolean pendingOrders) {
    this.pendingOrders = pendingOrders;
  }

  public Equipment eligibleInstallmentSubsidy(Boolean eligibleInstallmentSubsidy) {
    this.eligibleInstallmentSubsidy = eligibleInstallmentSubsidy;
    return this;
  }

   /**
   * Get eligibleInstallmentSubsidy
   * @return eligibleInstallmentSubsidy
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Boolean getEligibleInstallmentSubsidy() {
    return eligibleInstallmentSubsidy;
  }

  public void setEligibleInstallmentSubsidy(Boolean eligibleInstallmentSubsidy) {
    this.eligibleInstallmentSubsidy = eligibleInstallmentSubsidy;
  }

  public Equipment eu(String eu) {
    this.eu = eu;
    return this;
  }

   /**
   * Get eu
   * @return eu
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getEu() {
    return eu;
  }

  public void setEu(String eu) {
    this.eu = eu;
  }

  public Equipment ricEsnActiveIndicator(Boolean ricEsnActiveIndicator) {
    this.ricEsnActiveIndicator = ricEsnActiveIndicator;
    return this;
  }

   /**
   * Get ricEsnActiveIndicator
   * @return ricEsnActiveIndicator
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Boolean getRicEsnActiveIndicator() {
    return ricEsnActiveIndicator;
  }

  public void setRicEsnActiveIndicator(Boolean ricEsnActiveIndicator) {
    this.ricEsnActiveIndicator = ricEsnActiveIndicator;
  }

  public Equipment devfinCreditLimit(String devfinCreditLimit) {
    this.devfinCreditLimit = devfinCreditLimit;
    return this;
  }

   /**
   * Get devfinCreditLimit
   * @return devfinCreditLimit
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public String getDevfinCreditLimit() {
    return devfinCreditLimit;
  }

  public void setDevfinCreditLimit(String devfinCreditLimit) {
    this.devfinCreditLimit = devfinCreditLimit;
  }

  public Equipment lastCreditEvaulation(String lastCreditEvaulation) {
    this.lastCreditEvaulation = lastCreditEvaulation;
    return this;
  }

   /**
   * Get lastCreditEvaulation
   * @return lastCreditEvaulation
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getLastCreditEvaulation() {
    return lastCreditEvaulation;
  }

  public void setLastCreditEvaulation(String lastCreditEvaulation) {
    this.lastCreditEvaulation = lastCreditEvaulation;
  }

  public Equipment devfinCreditLimitAvailable(String devfinCreditLimitAvailable) {
    this.devfinCreditLimitAvailable = devfinCreditLimitAvailable;
    return this;
  }

   /**
   * Get devfinCreditLimitAvailable
   * @return devfinCreditLimitAvailable
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public String getDevfinCreditLimitAvailable() {
    return devfinCreditLimitAvailable;
  }

  public void setDevfinCreditLimitAvailable(String devfinCreditLimitAvailable) {
    this.devfinCreditLimitAvailable = devfinCreditLimitAvailable;
  }


  @Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Equipment other = (Equipment) obj;
	if (customerId == null) {
		if (other.customerId != null)
			return false;
	} else if (!customerId.equals(other.customerId))
		return false;
	if (devfinCreditLimit == null) {
		if (other.devfinCreditLimit != null)
			return false;
	} else if (!devfinCreditLimit.equals(other.devfinCreditLimit))
		return false;
	if (devfinCreditLimitAvailable == null) {
		if (other.devfinCreditLimitAvailable != null)
			return false;
	} else if (!devfinCreditLimitAvailable.equals(other.devfinCreditLimitAvailable))
		return false;
	if (devfinMeid == null) {
		if (other.devfinMeid != null)
			return false;
	} else if (!devfinMeid.equals(other.devfinMeid))
		return false;
	if (deviceDescription == null) {
		if (other.deviceDescription != null)
			return false;
	} else if (!deviceDescription.equals(other.deviceDescription))
		return false;
	if (eligibleInstallmentSubsidy == null) {
		if (other.eligibleInstallmentSubsidy != null)
			return false;
	} else if (!eligibleInstallmentSubsidy.equals(other.eligibleInstallmentSubsidy))
		return false;
	if (eu == null) {
		if (other.eu != null)
			return false;
	} else if (!eu.equals(other.eu))
		return false;
	if (firstName == null) {
		if (other.firstName != null)
			return false;
	} else if (!firstName.equals(other.firstName))
		return false;
	if (lastCreditEvaulation == null) {
		if (other.lastCreditEvaulation != null)
			return false;
	} else if (!lastCreditEvaulation.equals(other.lastCreditEvaulation))
		return false;
	if (lastName == null) {
		if (other.lastName != null)
			return false;
	} else if (!lastName.equals(other.lastName))
		return false;
	if (mdn == null) {
		if (other.mdn != null)
			return false;
	} else if (!mdn.equals(other.mdn))
		return false;
	if (pendingOrders == null) {
		if (other.pendingOrders != null)
			return false;
	} else if (!pendingOrders.equals(other.pendingOrders))
		return false;
	if (pin == null) {
		if (other.pin != null)
			return false;
	} else if (!pin.equals(other.pin))
		return false;
	if (protectionPlanCharges == null) {
		if (other.protectionPlanCharges != null)
			return false;
	} else if (!protectionPlanCharges.equals(other.protectionPlanCharges))
		return false;
	if (ricActiveIndicator == null) {
		if (other.ricActiveIndicator != null)
			return false;
	} else if (!ricActiveIndicator.equals(other.ricActiveIndicator))
		return false;
	if (ricBalance == null) {
		if (other.ricBalance != null)
			return false;
	} else if (!ricBalance.equals(other.ricBalance))
		return false;
	if (ricEndDate == null) {
		if (other.ricEndDate != null)
			return false;
	} else if (!ricEndDate.equals(other.ricEndDate))
		return false;
	if (ricEsnActiveIndicator == null) {
		if (other.ricEsnActiveIndicator != null)
			return false;
	} else if (!ricEsnActiveIndicator.equals(other.ricEsnActiveIndicator))
		return false;
	if (ricMonthlyFee == null) {
		if (other.ricMonthlyFee != null)
			return false;
	} else if (!ricMonthlyFee.equals(other.ricMonthlyFee))
		return false;
	if (ricStartDate == null) {
		if (other.ricStartDate != null)
			return false;
	} else if (!ricStartDate.equals(other.ricStartDate))
		return false;
	if (role == null) {
		if (other.role != null)
			return false;
	} else if (!role.equals(other.role))
		return false;
	if (upgradeEligiblityDate == null) {
		if (other.upgradeEligiblityDate != null)
			return false;
	} else if (!upgradeEligiblityDate.equals(other.upgradeEligiblityDate))
		return false;
	return true;
}

  @Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
	result = prime * result + ((devfinCreditLimit == null) ? 0 : devfinCreditLimit.hashCode());
	result = prime * result + ((devfinCreditLimitAvailable == null) ? 0 : devfinCreditLimitAvailable.hashCode());
	result = prime * result + ((devfinMeid == null) ? 0 : devfinMeid.hashCode());
	result = prime * result + ((deviceDescription == null) ? 0 : deviceDescription.hashCode());
	result = prime * result + ((eligibleInstallmentSubsidy == null) ? 0 : eligibleInstallmentSubsidy.hashCode());
	result = prime * result + ((eu == null) ? 0 : eu.hashCode());
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + ((lastCreditEvaulation == null) ? 0 : lastCreditEvaulation.hashCode());
	result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
	result = prime * result + ((mdn == null) ? 0 : mdn.hashCode());
	result = prime * result + ((pendingOrders == null) ? 0 : pendingOrders.hashCode());
	result = prime * result + ((pin == null) ? 0 : pin.hashCode());
	result = prime * result + ((protectionPlanCharges == null) ? 0 : protectionPlanCharges.hashCode());
	result = prime * result + ((ricActiveIndicator == null) ? 0 : ricActiveIndicator.hashCode());
	result = prime * result + ((ricBalance == null) ? 0 : ricBalance.hashCode());
	result = prime * result + ((ricEndDate == null) ? 0 : ricEndDate.hashCode());
	result = prime * result + ((ricEsnActiveIndicator == null) ? 0 : ricEsnActiveIndicator.hashCode());
	result = prime * result + ((ricMonthlyFee == null) ? 0 : ricMonthlyFee.hashCode());
	result = prime * result + ((ricStartDate == null) ? 0 : ricStartDate.hashCode());
	result = prime * result + ((role == null) ? 0 : role.hashCode());
	result = prime * result + ((upgradeEligiblityDate == null) ? 0 : upgradeEligiblityDate.hashCode());
	return result;
}

  @Override
public String toString() {
	return "Equipment [customerId=" + customerId + ", mdn=" + mdn + ", deviceDescription=" + deviceDescription
			+ ", firstName=" + firstName + ", lastName=" + lastName + ", role=" + role + ", pin=" + pin
			+ ", ricActiveIndicator=" + ricActiveIndicator + ", ricStartDate=" + ricStartDate + ", ricEndDate="
			+ ricEndDate + ", ricMonthlyFee=" + ricMonthlyFee + ", ricBalance=" + ricBalance
			+ ", protectionPlanCharges=" + protectionPlanCharges + ", upgradeEligiblityDate=" + upgradeEligiblityDate
			+ ", devfinMeid=" + devfinMeid + ", pendingOrders=" + pendingOrders + ", eligibleInstallmentSubsidy="
			+ eligibleInstallmentSubsidy + ", eu=" + eu + ", ricEsnActiveIndicator=" + ricEsnActiveIndicator
			+ ", devfinCreditLimit=" + devfinCreditLimit + ", lastCreditEvaulation=" + lastCreditEvaulation
			+ ", devfinCreditLimitAvailable=" + devfinCreditLimitAvailable + "]";
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

