package com.hepexta.activemqsubscribe.reciever;

public interface Listener {
    void listen(String message);
}
