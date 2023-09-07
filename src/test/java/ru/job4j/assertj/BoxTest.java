package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere")
                .hasSize(6)
                .doesNotContain("lol");
    }
    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron")
                .contains("Tetra")
                .doesNotContain("test");
    }
    @Test
    void getEightVertices() {
        Box box = new Box(8, 5);
        int number = box.getNumberOfVertices();
        assertThat(number).isEqualTo(8)
                .isGreaterThan(6)
                .isPositive()
                .isEven();
    }
    @Test
    void getMinusOneVertices() {
        Box box = new Box(7, 5);
        int number = box.getNumberOfVertices();
        assertThat(number).isEqualTo(-1)
                .isLessThan(6)
                .isNegative();
    }
    @Test
    void isExistTrue() {
        Box box = new Box(4, 5);
        boolean result = box.isExist();
        assertThat(result).isTrue()
                .isEqualTo(true)
                .isNotEqualTo(false);
    }
    @Test
    void isExistFalse() {
        Box box = new Box(5, 5);
        boolean result = box.isExist();
        assertThat(result).isFalse()
                .isEqualTo(false)
                .isNotEqualTo(true);
    }

    @Test
    void areaIs314() {
        Box box = new Box(0, 5);
        double result = box.getArea();
        assertThat(result).isEqualTo(314.1d, withPrecision(0.06d))
                .isGreaterThan(310.0d);
    }

    @Test
    void areaIs24() {
        Box box = new Box(8, 2);
        double result = box.getArea();
        assertThat(result).isNotEqualTo(25.0d)
                .isLessThan(310.0d)
                .isCloseTo(30.0d, Percentage.withPercentage(20.0d));
    }


}