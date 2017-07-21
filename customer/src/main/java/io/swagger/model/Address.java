package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import info.archinnov.achilles.annotations.Column;
import info.archinnov.achilles.annotations.Frozen;
import info.archinnov.achilles.annotations.PartitionKey;
import info.archinnov.achilles.annotations.Table;
import info.archinnov.achilles.annotations.UDT;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Address
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-07-06T15:59:15.554-04:00")

@UDT(name="addressudt")
public class Address   {

  @Column("adr_line_1")
  @JsonProperty("ADR_LINE_1")
  private String adRLINE1 = null;

  @Column("adr_line_2")
  @JsonProperty("ADR_LINE_2")
  private String adRLINE2 = null;

  @Column("adr_line_3")
  @JsonProperty("ADR_LINE_3")
  private String adRLINE3 = null;

  @Column("city")
  @JsonProperty("CITY")
  private String CITY = null;

  @Column("state")
  @JsonProperty("STATE")
  private String STATE = null;

  @Column("zip_code")
  @JsonProperty("ZIP_CODE")
  private String ZIP_CODE = null;

  @Column("country")
  @JsonProperty("COUNTRY")
  private String COUNTRY = null;

  public Address adRLINE1(String adRLINE1) {
    this.adRLINE1 = adRLINE1;
    return this;
  }

   /**
   * Get adRLINE1
   * @return adRLINE1
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getAdRLINE1() {
    return adRLINE1;
  }

  public void setAdRLINE1(String adRLINE1) {
    this.adRLINE1 = adRLINE1;
  }

  public void setZIP_CODE(String zIP_CODE) {
	ZIP_CODE = zIP_CODE;
}

public Address adRLINE2(String adRLINE2) {
    this.adRLINE2 = adRLINE2;
    return this;
  }

   /**
   * Get adRLINE2
   * @return adRLINE2
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getAdRLINE2() {
    return adRLINE2;
  }

  public void setAdRLINE2(String adRLINE2) {
    this.adRLINE2 = adRLINE2;
  }

  public Address adRLINE3(String adRLINE3) {
    this.adRLINE3 = adRLINE3;
    return this;
  }

   /**
   * Get adRLINE3
   * @return adRLINE3
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getAdRLINE3() {
    return adRLINE3;
  }

  public void setAdRLINE3(String adRLINE3) {
    this.adRLINE3 = adRLINE3;
  }

  public Address CITY(String CITY) {
    this.CITY = CITY;
    return this;
  }

   /**
   * Get CITY
   * @return CITY
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getCITY() {
    return CITY;
  }

  public void setCITY(String CITY) {
    this.CITY = CITY;
  }

  public Address STATE(String STATE) {
    this.STATE = STATE;
    return this;
  }

   /**
   * Get STATE
   * @return STATE
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getSTATE() {
    return STATE;
  }

  public String getZIP_CODE() {
	return ZIP_CODE;
}

public void setSTATE(String STATE) {
    this.STATE = STATE;
  }



  public Address COUNTRY(String COUNTRY) {
    this.COUNTRY = COUNTRY;
    return this;
  }

   /**
   * Get COUNTRY
   * @return COUNTRY
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getCOUNTRY() {
    return COUNTRY;
  }

  public void setCOUNTRY(String COUNTRY) {
    this.COUNTRY = COUNTRY;
  }



@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Address other = (Address) obj;
	if (CITY == null) {
		if (other.CITY != null)
			return false;
	} else if (!CITY.equals(other.CITY))
		return false;
	if (COUNTRY == null) {
		if (other.COUNTRY != null)
			return false;
	} else if (!COUNTRY.equals(other.COUNTRY))
		return false;
	if (STATE == null) {
		if (other.STATE != null)
			return false;
	} else if (!STATE.equals(other.STATE))
		return false;
	if (ZIP_CODE == null) {
		if (other.ZIP_CODE != null)
			return false;
	} else if (!ZIP_CODE.equals(other.ZIP_CODE))
		return false;
	if (adRLINE1 == null) {
		if (other.adRLINE1 != null)
			return false;
	} else if (!adRLINE1.equals(other.adRLINE1))
		return false;
	if (adRLINE2 == null) {
		if (other.adRLINE2 != null)
			return false;
	} else if (!adRLINE2.equals(other.adRLINE2))
		return false;
	if (adRLINE3 == null) {
		if (other.adRLINE3 != null)
			return false;
	} else if (!adRLINE3.equals(other.adRLINE3))
		return false;
	return true;
}

  @Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((CITY == null) ? 0 : CITY.hashCode());
	result = prime * result + ((COUNTRY == null) ? 0 : COUNTRY.hashCode());
	result = prime * result + ((STATE == null) ? 0 : STATE.hashCode());
	result = prime * result + ((ZIP_CODE == null) ? 0 : ZIP_CODE.hashCode());
	result = prime * result + ((adRLINE1 == null) ? 0 : adRLINE1.hashCode());
	result = prime * result + ((adRLINE2 == null) ? 0 : adRLINE2.hashCode());
	result = prime * result + ((adRLINE3 == null) ? 0 : adRLINE3.hashCode());
	return result;
}

  @Override
public String toString() {
	return "Address [adRLINE1=" + adRLINE1 + ", adRLINE2=" + adRLINE2 + ", adRLINE3=" + adRLINE3 + ", CITY=" + CITY
			+ ", STATE=" + STATE + ", ZIP_CODE=" + ZIP_CODE + ", COUNTRY=" + COUNTRY + "]";
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

