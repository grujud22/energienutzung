package trelud.energienutzung.service;

import org.junit.jupiter.api.Test;
import trelud.energienutzung.annotation.DtoEntity;
import trelud.energienutzung.annotation.ToDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DtoServiceTest {

    @DtoEntity
    static class Address {
        @ToDto
        String city = "Vienna";

        @ToDto(key = "zip")
        String postalCode = "1010";
    }

    static class PersonWithDefaultKey {
        @ToDto
        String name = "Max";

        @ToDto
        int age = 30;
    }

    static class PersonWithCustomKey {
        @ToDto(key = "fullName")
        String name = "Anna";
    }

    static class PersonWithNestedList {
        @ToDto
        List<Address> addresses = new ArrayList<>();
    }

    static class PersonWithUnAnnotatedField {
        String ignored = "should not appear";

        @ToDto
        String visible = "yes";
    }
}