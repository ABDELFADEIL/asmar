package com.aston.ecommerce.asmar.exption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class UserExpceptionTest {
    @Test
    void testConstructor() {
        UserExpception actualUserExpception = new UserExpception();
        assertNull(actualUserExpception.getCause());
        assertEquals("com.aston.ecommerce.asmar.exption.UserExpception", actualUserExpception.toString());
        assertEquals(0, actualUserExpception.getSuppressed().length);
        assertNull(actualUserExpception.getMessage());
        assertNull(actualUserExpception.getLocalizedMessage());
    }

    @Test
    void testConstructor2() {
        UserExpception actualUserExpception = new UserExpception("Not all who wander are lost");
        assertNull(actualUserExpception.getCause());
        assertEquals("com.aston.ecommerce.asmar.exption.UserExpception: Not all who wander are lost",
                actualUserExpception.toString());
        assertEquals(0, actualUserExpception.getSuppressed().length);
        assertEquals("Not all who wander are lost", actualUserExpception.getMessage());
        assertEquals("Not all who wander are lost", actualUserExpception.getLocalizedMessage());
    }

    @Test
    void testConstructor3() {
        Throwable throwable = new Throwable();
        UserExpception actualUserExpception = new UserExpception("Not all who wander are lost", throwable);

        Throwable cause = actualUserExpception.getCause();
        assertSame(throwable, cause);
        assertEquals("com.aston.ecommerce.asmar.exption.UserExpception: Not all who wander are lost",
                actualUserExpception.toString());
        assertEquals("Not all who wander are lost", actualUserExpception.getLocalizedMessage());
        Throwable[] suppressed = actualUserExpception.getSuppressed();
        assertEquals(0, suppressed.length);
        assertEquals("Not all who wander are lost", actualUserExpception.getMessage());
        assertNull(cause.getLocalizedMessage());
        assertNull(cause.getCause());
        assertEquals("java.lang.Throwable", cause.toString());
        assertNull(cause.getMessage());
        assertSame(suppressed, cause.getSuppressed());
        assertSame(cause, throwable);
    }

    @Test
    void testConstructor4() {
        Throwable throwable = new Throwable();
        UserExpception actualUserExpception = new UserExpception(throwable);
        Throwable cause = actualUserExpception.getCause();
        assertSame(throwable, cause);
        assertEquals("com.aston.ecommerce.asmar.exption.UserExpception: java.lang.Throwable",
                actualUserExpception.toString());
        assertEquals("java.lang.Throwable", actualUserExpception.getLocalizedMessage());
        Throwable[] suppressed = actualUserExpception.getSuppressed();
        assertEquals(0, suppressed.length);
        assertEquals("java.lang.Throwable", actualUserExpception.getMessage());
        assertNull(cause.getLocalizedMessage());
        assertNull(cause.getCause());
        assertEquals("java.lang.Throwable", cause.toString());
        assertNull(cause.getMessage());
        assertSame(suppressed, cause.getSuppressed());
        assertSame(cause, throwable);
    }
}

