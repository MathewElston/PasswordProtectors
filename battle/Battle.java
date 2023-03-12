package battle;

public class Battle {
    private BattleState battleState;

    public Battle() {
        // Initialize the battle state to the player's turn
        battleState = BattleState.PLAYER_TURN;
    }

    public void update() {
        switch (battleState) {
            case PLAYER_TURN:
                // Do something for the player's turn
                break;
            case ENEMY_TURN:
                // Do something for the enemy's turn
                break;
            case GAME_OVER:
                // Do something for the game over state
                break;
        }
    }

    public void setBattleState(BattleState state) {
        battleState = state;
    }
}
