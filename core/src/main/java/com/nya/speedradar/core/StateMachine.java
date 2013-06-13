package com.nya.speedradar.core;

public class StateMachine<T> {
    private State<T> currentState;
        private T owner;

        public StateMachine(T own, State<T> st)
        {
            owner = own;
            if (st != null) ChangeState(st);
            else currentState = null;
        }

        public void Update(int delta)
        {
            if (currentState != null) {
                currentState.Update(owner, delta);
                GoNextState(); // Changes state only if needed
            }
        }

        private void GoNextState()
        {
            if (currentState != null) currentState.GoNextState(this);
        }

        public void ChangeState(State<T> st)
        {
            if (currentState != null)
            {
                currentState.Exit(owner);
            }
            currentState = st;
            currentState.Enter(owner);
        }
}
