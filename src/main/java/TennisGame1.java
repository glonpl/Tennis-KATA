public class TennisGame1 {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }


    public void player1Score() {
        m_score1 += 1;
    }

    public void player2Score() {
        m_score2 += 1;
    }


    public String getScore() {
        if (isDeuce()) {
            return "Deuce";
        }
        if (isAll()) {
            return translateScore(m_score1) + "-All";
        }
        if (hasAdvantage()) {
            return "Advantage " + leadingName();
        }
        if (hasWinner()) {
            return "Win for " + leadingName();
        }
        return translateScore(m_score1) + "-" + translateScore(m_score2);
    }
/*==================================Booleans=========================================*/
    private boolean isAll() {
        return m_score1 == m_score2;
    }

    private boolean isDeuce() {
        return m_score1 >= 3 && m_score1 == m_score2;
    }


    private boolean hasWinner() {
        if (m_score2 >= 4 && m_score2 >= m_score1 + 2) {
            return true;
        }
        if (m_score1 >= 4 && m_score1 >= m_score2 + 2) {
            return true;
        }
        return false;
    }

    private boolean hasAdvantage() {
        if (m_score2 >= 4 && m_score2 == m_score1 + 1){
            return true;}
        if (m_score1 >= 4 && m_score1 == m_score2 + 1){
            return true;}
        return false;

    }
    /*==================================Strings=========================================*/
    private String leadingName() {
        return (m_score1 > m_score2) ? player1Name : player2Name;
    }

    private String translateScore(int tempScore) {

        switch (tempScore) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }
        return "";
    }
}
