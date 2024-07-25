CREATE TABLE barber (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    username VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE barber_shop (
    id UUID PRIMARY KEY,
    barber_id UUID,
    FOREIGN KEY (barber_id) REFERENCES barber(id)
);

CREATE TABLE client (
    phone_number VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255),
    barber_shop_id UUID,
    FOREIGN KEY (barber_shop_id) REFERENCES barber_shop(id)
);
