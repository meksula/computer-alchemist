package com.computeralchemist.domain.users;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 02-04-2018
 * */

public class UserTest {
    private User user = new User();

    private final long id = 9247523L;
    private final String username = "Nicolai_Copernicus";
    private final String name = "Mikołaj";
    private final String surname = "Kopernik";
    private final String email = "mikolai_cop_1468@gmail.com";
    private final int bornYear = 1424;

    @Test
    public void shouldInstantiateCorrectly() {
        assertNotNull(user);
    }

    @Before
    public void setUp() {
        user.setId(id);
        user.setUsername(username);
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setBornyear(bornYear);
    }

    @Test
    public void fieldShouldBeEquivalent() {
        assertEquals(id, user.getId());
        assertEquals(username, user.getUsername());
        assertEquals(name, user.getName());
        assertEquals(surname, user.getSurname());
        assertEquals(email, user.getEmail());
        assertEquals(bornYear, user.getBornyear());
    }

    private String prepareString() {
        String c = ", ";
        StringBuilder builder = new StringBuilder();
        builder.append(username).append(c).append(name).append(c).append(surname).append(c)
                .append(email).append(c).append(bornYear);
        return builder.toString();
    }

    @Test
    public void toStringMethodShouldGiveMainInfos() {
        String result = user.toString();
        assertEquals(prepareString(), result);
    }
}