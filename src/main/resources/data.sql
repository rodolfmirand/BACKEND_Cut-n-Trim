-- Criação da tabela BarberShop
CREATE TABLE BarberShop (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    street VARCHAR(255),
    number VARCHAR(255),
    neighborhood VARCHAR(255),
    city VARCHAR(255),
    state VARCHAR(255),
    cep VARCHAR(255),
    openingTime int,
    closingTime int,
    lunchTimeStart int,
    lunchTimeEnd int
);

-- Criação da tabela Barber
CREATE TABLE Barber (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    barberShop_id UUID UNIQUE,
    CONSTRAINT fk_barberShop FOREIGN KEY (barberShop_id) REFERENCES BarberShop(id) ON DELETE CASCADE
);

-- Atualização da tabela BarberShop para adicionar a relação bidirecional
ALTER TABLE BarberShop
ADD CONSTRAINT fk_barber FOREIGN KEY (id) REFERENCES Barber(id) ON DELETE CASCADE;

-- Criação da tabela Client
CREATE TABLE Client (
    id UUID PRIMARY KEY,
    phoneNumber VARCHAR(255),
    name VARCHAR(255),
    barber_shop_id UUID,
    CONSTRAINT fk_client_barberShop FOREIGN KEY (barber_shop_id) REFERENCES BarberShop(id) ON DELETE CASCADE
);
