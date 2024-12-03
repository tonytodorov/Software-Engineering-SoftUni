package softuni.exam.repository;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Device;
import softuni.exam.models.entity.DeviceType;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    Optional<Device> findByBrandAndModel(String brand, String model);

    List<Device> findByDeviceTypeAndPriceLessThanAndStorageGreaterThanEqualOrderByBrand(DeviceType deviceType, double price, int storage);
}
