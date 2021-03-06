package com.openbox.realcomm.database.objects;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.openbox.realcomm.utilities.helpers.StringHelper;

@DatabaseTable(tableName = "Company")
public class Company implements Serializable
{
	// Generated Serializable UID
	private static final long serialVersionUID = 1566568241666455317L;

	public static final Class<?> ID_CLASS = Integer.class;

	/**********************************************************************************************
	 * Column Names
	 **********************************************************************************************/
	public static final String COMPANY_ID_COLUMN_NAME = "CompanyId";
	public static final String NAME_COLUMN_NAME = "Name";
	public static final String DESCRIPTION_COLUMN_NAME = "Description";
	public static final String SHORT_DESCRIPTION_COLUMN_NAME = "ShortDescription";
	public static final String WEBSITE_COLUMN_NAME = "Website";
	public static final String RELATED_LINKS_COLUMN_NAME = "RelatedLinks";
	public static final String CONFERENCE_NAME_COLUMN_NAME = "ConferenceName";
	public static final String COUNTRY_COLUMN_NAME = "Country";
	public static final String CITY_COLUMN_NAME = "City";
	public static final String STATE_COLUMN_NAME = "State";
	public static final String ADDRESS_1_COLUMN_NAME = "Address1";
	public static final String ADDRESS_2_COLUMN_NAME = "Address2";
	public static final String ADDRESS_3_COLUMN_NAME = "Address3";
	public static final String POSTAL_CODE_COLUMN_NAME = "PostalCode";
	public static final String FACEBOOK_COLUMN_NAME = "Facebook";
	public static final String FACEBOOK_PROFILE_ID_COLUMN_NAME = "FacebookProfileId";
	public static final String TWITTER_COLUMN_NAME = "Twitter";
	public static final String LINKEDIN_COLUMN_NAME = "LinkedIn";
	public static final String MAIN_CATEGORIES_COLUMN_NAME = "MainCategories";
	public static final String SUB_CATEGORIES_COLUMN_NAME = "SubCategories";
	public static final String TARGET_MARKETS_COLUMN_NAME = "TargetMarkets";
	public static final String CLIENT_SAMPLING_COLUMN_NAME = "ClientSampling";
	public static final String GEOGRAPHIC_MARKETS_COLUMN_NAME = "GeographicMarkets";

	/**********************************************************************************************
	 * Database Fields
	 **********************************************************************************************/
	@DatabaseField(id = true, columnName = COMPANY_ID_COLUMN_NAME)
	@SerializedName(COMPANY_ID_COLUMN_NAME)
	private int companyId;

	@DatabaseField(columnName = NAME_COLUMN_NAME)
	@SerializedName(NAME_COLUMN_NAME)
	private String name;

	@DatabaseField(columnName = DESCRIPTION_COLUMN_NAME)
	@SerializedName(DESCRIPTION_COLUMN_NAME)
	private String description;

	@DatabaseField(columnName = SHORT_DESCRIPTION_COLUMN_NAME)
	@SerializedName(SHORT_DESCRIPTION_COLUMN_NAME)
	private String shortDescription;

	@DatabaseField(columnName = WEBSITE_COLUMN_NAME)
	@SerializedName(WEBSITE_COLUMN_NAME)
	private String website;

	@DatabaseField(columnName = RELATED_LINKS_COLUMN_NAME)
	@SerializedName(RELATED_LINKS_COLUMN_NAME)
	private String relatedLinks;

	@DatabaseField(columnName = CONFERENCE_NAME_COLUMN_NAME)
	@SerializedName(CONFERENCE_NAME_COLUMN_NAME)
	private String conferenceName;

	@DatabaseField(columnName = COUNTRY_COLUMN_NAME)
	@SerializedName(COUNTRY_COLUMN_NAME)
	private String country;

	@DatabaseField(columnName = CITY_COLUMN_NAME)
	@SerializedName(CITY_COLUMN_NAME)
	private String city;

	@DatabaseField(columnName = STATE_COLUMN_NAME)
	@SerializedName(STATE_COLUMN_NAME)
	private String state;

	@DatabaseField(columnName = ADDRESS_1_COLUMN_NAME)
	@SerializedName(ADDRESS_1_COLUMN_NAME)
	private String address1;

	@DatabaseField(columnName = ADDRESS_2_COLUMN_NAME)
	@SerializedName(ADDRESS_2_COLUMN_NAME)
	private String address2;

	@DatabaseField(columnName = ADDRESS_3_COLUMN_NAME)
	@SerializedName(ADDRESS_3_COLUMN_NAME)
	private String address3;

	@DatabaseField(columnName = POSTAL_CODE_COLUMN_NAME)
	@SerializedName(POSTAL_CODE_COLUMN_NAME)
	private String postalCode;

	@DatabaseField(columnName = FACEBOOK_COLUMN_NAME)
	@SerializedName(FACEBOOK_COLUMN_NAME)
	private String facebook;

	@DatabaseField(columnName = FACEBOOK_PROFILE_ID_COLUMN_NAME)
	@SerializedName(FACEBOOK_PROFILE_ID_COLUMN_NAME)
	private String facebookProfileId;

	@DatabaseField(columnName = TWITTER_COLUMN_NAME)
	@SerializedName(TWITTER_COLUMN_NAME)
	private String twitter;

	@DatabaseField(columnName = LINKEDIN_COLUMN_NAME)
	@SerializedName(LINKEDIN_COLUMN_NAME)
	private String linkedIn;

	@DatabaseField(columnName = MAIN_CATEGORIES_COLUMN_NAME)
	@SerializedName(MAIN_CATEGORIES_COLUMN_NAME)
	private String mainCategories;

	@DatabaseField(columnName = SUB_CATEGORIES_COLUMN_NAME)
	@SerializedName(SUB_CATEGORIES_COLUMN_NAME)
	private String subCategories;

	@DatabaseField(columnName = TARGET_MARKETS_COLUMN_NAME)
	@SerializedName(TARGET_MARKETS_COLUMN_NAME)
	private String targetMarkets;

	@DatabaseField(columnName = CLIENT_SAMPLING_COLUMN_NAME)
	@SerializedName(CLIENT_SAMPLING_COLUMN_NAME)
	private String clientSampling;

	@DatabaseField(columnName = GEOGRAPHIC_MARKETS_COLUMN_NAME)
	@SerializedName(GEOGRAPHIC_MARKETS_COLUMN_NAME)
	private String geographicMarkets;

	public Company()
	{
		// all persisted classes must define a no-arg constructor with at least package visibility
	}

	/**********************************************************************************************
	 * Property Get and Setters
	 **********************************************************************************************/
	public int getCompanyId()
	{
		return companyId;
	}

	public void setCompanyId(int companyId)
	{
		this.companyId = companyId;
	}

	public String getName()
	{
		return StringHelper.nullOrTrim(name);
	}

	public void setName(String name)
	{
		this.name = StringHelper.nullOrTrim(name);
	}

	public String getDescription()
	{
		return StringHelper.nullOrTrim(description);
	}

	public void setDescription(String description)
	{
		this.description = StringHelper.nullOrTrim(description);
	}

	public String getShortDescription()
	{
		return StringHelper.nullOrTrim(shortDescription);
	}

	public void setShortDescription(String shortDescription)
	{
		this.shortDescription = StringHelper.nullOrTrim(shortDescription);
	}

	public String getWebsite()
	{
		return StringHelper.nullOrTrim(website);
	}

	public void setWebsite(String website)
	{
		this.website = StringHelper.nullOrTrim(website);
	}

	public String getRelatedLinks()
	{
		return StringHelper.nullOrTrim(relatedLinks);
	}

	public void setRelatedLinks(String relatedLinks)
	{
		this.relatedLinks = StringHelper.nullOrTrim(relatedLinks);
	}

	public String getConferenceName()
	{
		return StringHelper.nullOrTrim(conferenceName);
	}

	public void setConferenceName(String conferenceName)
	{
		this.conferenceName = StringHelper.nullOrTrim(conferenceName);
	}

	public String getCountry()
	{
		return StringHelper.nullOrTrim(country);
	}

	public void setCountry(String country)
	{
		this.country = StringHelper.nullOrTrim(country);
	}

	public String getCity()
	{
		return StringHelper.nullOrTrim(city);
	}

	public void setCity(String city)
	{
		this.city = StringHelper.nullOrTrim(city);
	}

	public String getState()
	{
		return StringHelper.nullOrTrim(state);
	}

	public void setState(String state)
	{
		this.state = StringHelper.nullOrTrim(state);
	}

	public String getAddress1()
	{
		return StringHelper.nullOrTrim(address1);
	}

	public void setAddress1(String address1)
	{
		this.address1 = StringHelper.nullOrTrim(address1);
	}

	public String getAddress2()
	{
		return StringHelper.nullOrTrim(address2);
	}

	public void setAddress2(String address2)
	{
		this.address2 = StringHelper.nullOrTrim(address2);
	}

	public String getAddress3()
	{
		return StringHelper.nullOrTrim(address3);
	}

	public void setAddress3(String address3)
	{
		this.address3 = StringHelper.nullOrTrim(address3);
	}

	public String getPostalCode()
	{
		return StringHelper.nullOrTrim(postalCode);
	}

	public void setPostalCode(String postalCode)
	{
		this.postalCode = StringHelper.nullOrTrim(postalCode);
	}

	public String getFacebook()
	{
		return StringHelper.nullOrTrim(facebook);
	}

	public void setFacebook(String facebook)
	{
		this.facebook = StringHelper.nullOrTrim(facebook);
	}

	public String getFacebookProfileId()
	{
		return StringHelper.nullOrTrim(facebookProfileId);
	}

	public void setFacebookProfileId(String facebookProfileId)
	{
		this.facebookProfileId = StringHelper.nullOrTrim(facebookProfileId);
	}

	public String getTwitter()
	{
		return StringHelper.nullOrTrim(twitter);
	}

	public void setTwitter(String twitter)
	{
		this.twitter = StringHelper.nullOrTrim(twitter);
	}

	public String getLinkedIn()
	{
		return StringHelper.nullOrTrim(linkedIn);
	}

	public void setLinkedIn(String linkedIn)
	{
		this.linkedIn = StringHelper.nullOrTrim(linkedIn);
	}

	public String getMainCategories()
	{
		return StringHelper.nullOrTrim(mainCategories);
	}

	public void setMainCategories(String mainCategories)
	{
		this.mainCategories = StringHelper.nullOrTrim(mainCategories);
	}

	public String getSubCategories()
	{
		return StringHelper.nullOrTrim(subCategories);
	}

	public void setSubCategories(String subCategories)
	{
		this.subCategories = StringHelper.nullOrTrim(subCategories);
	}

	public String getTargetMarkets()
	{
		return StringHelper.nullOrTrim(targetMarkets);
	}

	public void setTargetMarkets(String targetMarkets)
	{
		this.targetMarkets = StringHelper.nullOrTrim(targetMarkets);
	}

	public String getClientSampling()
	{
		return StringHelper.nullOrTrim(clientSampling);
	}

	public void setClientSampling(String clientSampling)
	{
		this.clientSampling = StringHelper.nullOrTrim(clientSampling);
	}

	public String getGeographicMarkets()
	{
		return StringHelper.nullOrTrim(geographicMarkets);
	}

	public void setGeographicMarkets(String geographicMarkets)
	{
		this.geographicMarkets = StringHelper.nullOrTrim(geographicMarkets);
	}
}
