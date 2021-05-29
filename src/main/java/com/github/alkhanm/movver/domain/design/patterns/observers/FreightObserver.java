package com.github.alkhanm.movver.domain.design.patterns.observers;

public interface FreightObserver {
    void notifyAcceptance();
}

/* STATE: representa o estado do frete ("Aguardando" | "A caminho" | "Finalizada" | "Cancelada")
 * OBSERVER: notifica o usuário sempre que o estado da corrida mudar
 * FACTORY METHOD: ????
 */