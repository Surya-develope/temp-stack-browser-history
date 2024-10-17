package com.github.affandes.kuliah.pm;
import java.util.ArrayList;
import java.util.Scanner;

public class BrowserHistorySimulator {
    public static void main(String[] args) {
        BrowserHistory browser = new BrowserHistory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. View History");
            System.out.println("2. Browse");
            System.out.println("3. Back");
            System.out.println("4. Exit");

            System.out.print("Pilih menu (1-4): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    browser.view();
                    break;
                case "2":
                    System.out.print("Masukkan URL: ");
                    String url = scanner.nextLine();
                    browser.browse(url);
                    break;
                case "3":
                    browser.back();
                    break;
                case "4":
                    System.out.println("Terima kasih telah menggunakan Browser History Simulator.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}

class BrowserHistory {
    private ArrayList<String> history;

    public BrowserHistory() {
        this.history = new ArrayList<>();
    }

    public void view() {
        if (history.isEmpty()) {
            System.out.println("History kosong.");
        } else {
            System.out.println("Browser History:");
            for (int i = history.size() - 1; i >= 0; i--) {
                System.out.println((history.size() - i) + ". " + history.get(i));
            }
        }
    }

    public void browse(String url) {
        history.add(url);
        System.out.println("Mengunjungi: " + url);
    }

    public void back() {
        if (history.isEmpty()) {
            System.out.println("Tidak dapat kembali. History kosong.");
        } else {
            String removedUrl = history.remove(history.size() - 1);
            System.out.println("Kembali dari: " + removedUrl);
            if (!history.isEmpty()) {
                System.out.println("Sekarang di: " + history.get(history.size() - 1));
            } else {
                System.out.println("Kembali ke halaman awal.");
            }
        }
    }
}
