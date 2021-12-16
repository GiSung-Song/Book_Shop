package com.shop.shop.dto;

import com.shop.shop.constant.ItemSellStatus;
import com.shop.shop.entity.Item;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ItemFormDto {

    private Long id;

    @NotBlank(message = "상품명은 필수 입력 값입니다")
    private String itemNm; //상품명

    @NotNull(message = "가격은 필수 입력 값입니다.")
    private Integer price; //상품 가격

    @NotBlank(message = "상품 설명은 필수 입력 값입니다.")
    private String itemDetail; //상품 설명

    @NotNull(message = "재고는 필수 입력 값입니다.")
    private Integer stockNumber; //재고

    private ItemSellStatus itemSellStatus; //상품 판매 현황

    private List<ItemImgDto> itemImgDtoList = new ArrayList<>(); //상품 저장 후 수정할 때 상품 이미지 정보 저장

    private List<Long> itemImgIds = new ArrayList<>(); //상품의 이미지 아이디를 저장

    private static ModelMapper modelMapper = new ModelMapper();

    public Item createItem() {
        return modelMapper.map(this, Item.class);
    }

    public static ItemFormDto of(Item item) {
        return modelMapper.map(item, ItemFormDto.class);
    }
}
