package com.privalia.dao;

import java.io.IOException;

public interface IDao<T> {
    T add(T model) throws IOException;
}
