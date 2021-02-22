package net.kevinboone.apacheintegration.camelxmljson.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
public class Customer
  {
  @XmlElement
  private String name;
  @XmlElement
  private String id;

  public String getName() 
    {
    return name;
    }

  public void setName(String name) 
    {
    this.name = name;
    }

  public String getId() 
    {
    return id;
    }

  public void setId(String id) 
    {
    this.id = id;
    }

  }

