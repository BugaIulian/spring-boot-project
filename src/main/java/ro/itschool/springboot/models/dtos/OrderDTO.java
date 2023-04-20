package ro.itschool.springboot.models.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderDTO implements Serializable {

    private String productName;
}