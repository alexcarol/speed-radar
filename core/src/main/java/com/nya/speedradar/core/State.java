package com.nya.speedradar.core;

public abstract class State<T> {
    abstract public void Enter(T owner);
    abstract public void Update(T owner, int delta);
    abstract public void Exit(T owner);
    abstract public void GoNextState(StateMachine<T> fsm); // Changes state only if needed
}
