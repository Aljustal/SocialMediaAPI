package ru.mobile.effective.SocialMediaAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mobile.effective.SocialMediaAPI.model.Friendship;

@Repository
public interface FriendshipRepository extends JpaRepository<Friendship, Long> {
}