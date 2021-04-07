package bai8_clean_code_refactoring.bai_tap;

public class TennisGame {
    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        String hienThi = "";
        boolean tySoHoa = player1Score == player2Score;
        boolean nguoiThang = player1Score >= 4 || player2Score >= 4;
        if (tySoHoa) {
            hienThi = getHoa(player1Score);
        } else if (nguoiThang) {
            hienThi = getKetQua(player1Score, player2Score);
        } else {
           hienThi = getTySo(player1Score, player2Score);
        }
        return hienThi;
    }
    public static String getHoa(int player1Score) {
        String diplay ="";
        switch (player1Score) {
            case 0:
                diplay = "Love-All";
                break;
            case 1:
                diplay = "Fifteen-All";
                break;
            case 2:
                diplay = "Thirty-All";
                break;
            case 3:
                diplay = "Forty-All";
                break;
            default:
                diplay = "Deuce";
                break;
        }
        return diplay;
    }
    public static String getKetQua(int player1Score, int player2Score) {
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) return "Advantage player1";
        else if (minusResult == -1) return "Advantage player2";
        else if (minusResult >= 2) return "Win for player1";
        else return "Win for player2";
    }
    public static String getTySo(int player1Score, int player2Score) {
        int tempScore = 0;
        String diplay ="";
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = player1Score;
            else {
                diplay += "-";
                tempScore = player2Score;
            }
            switch (tempScore) {
                case 0:
                    diplay += "Love";
                    break;
                case 1:
                    diplay += "Fifteen";
                    break;
                case 2:
                    diplay += "Thirty";
                    break;
                case 3:
                    diplay += "Forty";
                    break;
            }
        }
        return diplay;
    }
}
