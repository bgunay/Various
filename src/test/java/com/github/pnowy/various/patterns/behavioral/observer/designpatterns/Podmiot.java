package com.github.pnowy.various.patterns.behavioral.observer.designpatterns;

public interface Podmiot
{
    public void zarejestrujObserwatora(Obserwator o);

    public void usunObserwatora(Obserwator o);

    public void powiadomObserwatorow();
}