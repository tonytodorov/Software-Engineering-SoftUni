package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.entities.Label;
import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {

    List<Shampoo> findByBrand(String brand);

    List<Shampoo> findBySizeOrderById(Size size);

    List<Shampoo> findBySizeOrLabelIdOrderByPrice(Size size, long labelId);

    List<Shampoo> findBySizeOrLabelOrderByPrice(Size size, Label label);

    List<Shampoo> findByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    List<Shampoo> findShampoosByPriceIsLessThan(BigDecimal price);

    List<Shampoo> findByIngredientsNameIn(List<String> ingredients);

    @Query("SELECT s FROM Shampoo AS s" +
            " JOIN s.ingredients AS i" +
            " WHERE i.name IN :names")
    List<Shampoo> findByIngredientsNameInQuery(@Param("names") List<String> ingredients);

    @Query("""
        SELECT s FROM Shampoo AS s
        WHERE SIZE(s.ingredients) < :count
        """)
    List<Shampoo> findByIngredientsCountLessThan(int count);



}
