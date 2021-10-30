package stock;

import org.springframework.data.jpa.repository.JpaRepository;

interface OrderRepository extends JpaRepository<ProductOrder,Long> {
}
