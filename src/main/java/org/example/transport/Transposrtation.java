package org.example.transport;

sealed interface Transposrtation permits  Airtransport, Railtransport, Roadtransposrt {
    void transport();
    void show();
    void display();
}
