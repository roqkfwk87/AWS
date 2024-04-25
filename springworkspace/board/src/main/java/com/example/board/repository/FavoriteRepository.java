package com.example.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.board.entity.FavoriteEntity;
import com.example.board.entity.pk.FavoritePk;

public interface FavoriteRepository extends JpaRepository<FavoriteEntity, FavoritePk> {
    
}