package com.info.edp.entiry;

import com.info.edp.config.Encrypt;
import jakarta.persistence.*;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Convert(converter = Encrypt.class)
  private String username;

  @Convert(converter = Encrypt.class)
  private String street;

  @Convert(converter = Encrypt.class)
  private String city;

  @Convert(converter = Encrypt.class)
  private String country;

  @Column(name = "created_date")
  private Date createdDate;


  @Column(name = "last_modified_date")
  private Date lastModifiedDate;
}