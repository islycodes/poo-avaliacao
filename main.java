import java.awt.HeadlessException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class main {

    public static int menu(double carrinho) {
        int option = -1;
                //Solicita a entrada para o usuário
                try {String text = JOptionPane.showInputDialog (
                    null, 
                    "*---------- BEM VINDO A LANCHONETE P2 ----------*" +
                    " \n\n0. Sair \n1. Pizza de Abobrinha R$ 15,45 \n2. Suco de Cenoura R$  6,35" +
                    " \n3. Empada de Frango R$ 17,59 \n4. Sorvete de Abacaxi R$ 12,10 \n5. Risoto de limão R$ 37,95" +
                    " \n6. Porção de Batata-frita  R$ 18,25 \n7. Cone de Oreo R$ 12,69 \n8. Água R$  2,25" +
                    " \n9. Consultar Carrinho\n" +
                    " \nDigite uma opção: ", "Cardápio",
                    JOptionPane.PLAIN_MESSAGE);
                    
                    if ((text != null && Integer.parseInt(text) >= 0) && (Integer.parseInt(text) <= 9)) {
                        option = Integer.parseInt(text);
                    }

                    else if(text == null ){
                        option = 0;
                    }
                    
                    else if((Integer.parseInt(text) < 0) || (Integer.parseInt(text) > 9)){
                        JOptionPane.showMessageDialog (null, "O menu só funciona com a inserção de um valor númerico válido.", "Erro",
                                JOptionPane.ERROR_MESSAGE); 

                                return -1;
                        
                    }
                }                                                   
                    //Tratamento de erro, caso o usuário não insira um valor numérico
                        catch(HeadlessException | NumberFormatException e) {
                            JOptionPane.showMessageDialog (null, "O menu só funciona com a inserção de um valor númerico válido.", "Erro",
                                JOptionPane.ERROR_MESSAGE);                   
                            }  
                
                return option;
    }

    public static void main(String[] args) {
        int option = -1, n = -1, m = -1;
        double carrinho = 0;

        DecimalFormat decimal = new DecimalFormat("#.##");
        String valorFormatado = "";

        String valorFinalFormatado = "";

        while(option != 0) {
        
        option = menu(carrinho);
    
                switch(option){ 
                
                    case 0: 
                    if(carrinho > 0) {
                        valorFormatado = decimal.format(carrinho);
                        valorFinalFormatado = decimal.format(carrinho - (0.1 * carrinho));

                        m = JOptionPane.showConfirmDialog (null, "Você participa do clube P2?", "CLUBE DE DESCONTO",
                        JOptionPane.YES_NO_OPTION);
                        if(m != 0) {
                            JOptionPane.showMessageDialog (null, "Pague sua conta de: R$ " + (valorFormatado), "CAIXA",
                            JOptionPane.WARNING_MESSAGE);
                            JOptionPane.showMessageDialog (null, "Deu tudo certo com seu pagamento, tenha uma Boa noite!", "Pagamento Autorizado",
                            JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog (null, "Pague sua conta de: R$ " + (valorFormatado) + " com 10% de desconto por participar do clube." + "\nTotal a ser pago: R$ " +
                            (valorFinalFormatado), "CAIXA",
                            JOptionPane.WARNING_MESSAGE);
                            JOptionPane.showMessageDialog (null, "Deu tudo certo com seu pagamento, tenha uma Boa noite!", "Pagamento Autorizado",
                            JOptionPane.INFORMATION_MESSAGE);
                        }
                    } 


                    else {
                        n = JOptionPane.showConfirmDialog (null, "Deseja sair do programa?");
                        if(n != 0){
                            option = -1;
                        }
                    }
                    break;

                case 1: carrinho += 15.45; break;
                    
                case 2: carrinho += 6.35; break;
                    
                case 3: carrinho += 17.59; break;
                    
                case 4: carrinho += 12.10; break;
                    
                case 5: carrinho += 37.95; break;

                case 6: carrinho += 18.25; break;
                                   
                case 7: carrinho += 12.69; break;

                case 8: carrinho += 2.25; break;

                case 9:
                valorFormatado = decimal.format(carrinho);
        
                JOptionPane.showMessageDialog (null, "Valor atual: R$ " + (valorFormatado), "Carrinho",
                JOptionPane.WARNING_MESSAGE); break;
                
                default: option = -1;
                }     
        
            }
    }
}