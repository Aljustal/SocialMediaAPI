package ru.mobile.effective.SocialMediaAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mobile.effective.SocialMediaAPI.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
