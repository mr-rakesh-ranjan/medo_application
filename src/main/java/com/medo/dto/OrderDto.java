package com.medo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.StringJoiner;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private String status;
    private long totalAmount;
    private int items;

    @Override
    public String toString() {
        return new StringJoiner(", ", OrderDto.class.getSimpleName() + "[", "]")
                .add("status='" + status + "'")
                .add("totalAmount=" + totalAmount)
                .add("items=" + items)
                .toString();
    }
}
