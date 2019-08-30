package qapitol.demo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import qapitol.demo.app.entity.Blogger;

@Repository
public interface BloggerRepository extends JpaRepository<Blogger, Integer> {

}
