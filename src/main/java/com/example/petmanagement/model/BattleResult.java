package com.example.petmanagement.model;

public class BattleResult {
    
    private String winner;
    private String loser;
    private Integer damageDealt;
    private String battleDescription;
    private String specialMove;
    
    public BattleResult() {
    }
    
    public BattleResult(String winner, String loser, Integer damageDealt, String battleDescription) {
        this.winner = winner;
        this.loser = loser;
        this.damageDealt = damageDealt;
        this.battleDescription = battleDescription;
    }
    
    public String getWinner() {
        return winner;
    }
    
    public void setWinner(String winner) {
        this.winner = winner;
    }
    
    public String getLoser() {
        return loser;
    }
    
    public void setLoser(String loser) {
        this.loser = loser;
    }
    
    public Integer getDamageDealt() {
        return damageDealt;
    }
    
    public void setDamageDealt(Integer damageDealt) {
        this.damageDealt = damageDealt;
    }
    
    public String getBattleDescription() {
        return battleDescription;
    }
    
    public void setBattleDescription(String battleDescription) {
        this.battleDescription = battleDescription;
    }
    
    public String getSpecialMove() {
        return specialMove;
    }
    
    public void setSpecialMove(String specialMove) {
        this.specialMove = specialMove;
    }
}
