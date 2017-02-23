/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemmachine.ui;

import problemmachine.logiikka.Logiikka;

/**
 *
 * @author lkaranko
 */
public class Kayttoliittyma extends javax.swing.JFrame {

    /**
     * Creates new form Kayttoliittyma
     */
    private Logiikka logic;

    public Kayttoliittyma(Logiikka logic) {
        this.logic = logic;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        palautaMalliVastaus = new javax.swing.JButton();
        uusiKysymys = new javax.swing.JButton();
        palautaVastaus = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        vastauksenLukinta = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        matematiikkaNappi = new javax.swing.JButton();
        kemiaNappi = new javax.swing.JButton();
        fysiikkaNappi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(110, 103, 238));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Kysymys.");
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
        );

        palautaMalliVastaus.setText("Mallivastaus!");
        palautaMalliVastaus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                palautaMalliVastausActionPerformed(evt);
            }
        });

        uusiKysymys.setText("Vaihda Kysymystä!");
        uusiKysymys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uusiKysymysActionPerformed(evt);
            }
        });

        palautaVastaus.setText("Vastaus!");
        palautaVastaus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                palautaVastausActionPerformed(evt);
            }
        });

        jTextField1.setText("Vastaukseni");
        jTextField1.setToolTipText("Anna vastaus enimmillään 2 desimaalin tarkkuudella.");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        vastauksenLukinta.setText("Lukitsen Vastaukseni!");
        vastauksenLukinta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vastauksenLukintaActionPerformed(evt);
            }
        });

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setText("Vastaus");
        jTextArea2.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTextArea2);

        matematiikkaNappi.setText("Matematiikka");
        matematiikkaNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matematiikkaNappiActionPerformed(evt);
            }
        });

        kemiaNappi.setText("Kemia");
        kemiaNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kemiaNappiActionPerformed(evt);
            }
        });

        fysiikkaNappi.setText("Fysiikka");
        fysiikkaNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fysiikkaNappiActionPerformed(evt);
            }
        });

        jLabel1.setText("Pisteet:");

        jLabel3.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(uusiKysymys, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(palautaVastaus, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                        .addComponent(palautaMalliVastaus, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vastauksenLukinta))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fysiikkaNappi, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kemiaNappi, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(matematiikkaNappi)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matematiikkaNappi)
                    .addComponent(kemiaNappi)
                    .addComponent(fysiikkaNappi)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vastauksenLukinta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(palautaMalliVastaus)
                    .addComponent(uusiKysymys)
                    .addComponent(palautaVastaus))
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleName("Kysymyspaneeli");

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed


    private void uusiKysymysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uusiKysymysActionPerformed
        logic.haeTehtava();
        jTextArea1.setText(logic.getKysymysMuuttujilla());
    }//GEN-LAST:event_uusiKysymysActionPerformed

    private void palautaVastausActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_palautaVastausActionPerformed
        jTextArea2.setText(logic.getVastausMuuttujilla());
    }//GEN-LAST:event_palautaVastausActionPerformed

    private void palautaMalliVastausActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_palautaMalliVastausActionPerformed
        jTextArea2.setText(logic.getLaajaVastausMuuttujilla());
    }//GEN-LAST:event_palautaMalliVastausActionPerformed

    private void vastauksenLukintaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vastauksenLukintaActionPerformed
        if (logic.tarkistaVastaus(jTextField1.getText())) {
            jTextField1.setText("Oikein!");
            jLabel3.setText(logic.getPisteet());
            jTextArea2.setText(logic.getLaajaVastausMuuttujilla());
        } else {
            jTextField1.setText("Väärin!");
        }
    }//GEN-LAST:event_vastauksenLukintaActionPerformed

    private void kemiaNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kemiaNappiActionPerformed
        logic.kaynnista("kysymyksetKemia.txt");
        logic.haeTehtava();
        jTextArea1.setText(logic.getKysymysMuuttujilla());
    }//GEN-LAST:event_kemiaNappiActionPerformed

    private void fysiikkaNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fysiikkaNappiActionPerformed
        logic.kaynnista("kysymyksetFysiikka.txt");
        logic.haeTehtava();
        jTextArea1.setText(logic.getKysymysMuuttujilla());
    }//GEN-LAST:event_fysiikkaNappiActionPerformed

    private void matematiikkaNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matematiikkaNappiActionPerformed

        logic.kaynnista("kysymyksetMatematiikka.txt");
        logic.haeTehtava();
        jTextArea1.setText(logic.getKysymysMuuttujilla());
    }//GEN-LAST:event_matematiikkaNappiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fysiikkaNappi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton kemiaNappi;
    private javax.swing.JButton matematiikkaNappi;
    private javax.swing.JButton palautaMalliVastaus;
    private javax.swing.JButton palautaVastaus;
    private javax.swing.JButton uusiKysymys;
    private javax.swing.JButton vastauksenLukinta;
    // End of variables declaration//GEN-END:variables
}