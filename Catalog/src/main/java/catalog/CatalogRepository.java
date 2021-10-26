package catalog;

import org.springframework.data.jpa.repository.JpaRepository;

interface CatalogRepository extends JpaRepository<Product,Long> {
}
