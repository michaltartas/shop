package shop;

import org.springframework.data.jpa.repository.JpaRepository;

interface Productrepository extends JpaRepository<Product,Long> {
}
