package org.example.printer;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class Printer implements Runnable{
    final State state;
    PrinterType currentPrinter;
    PrinterType nextPrinter;
    int step;
    int count;

    @SneakyThrows
    @Override
    public void run() {
        synchronized (state) {
            while(this.currentPrinter != state.nextPrinterType){
                state.wait();
            }
            System.out.println(count);
            count+=step;
            Thread.sleep(1000);
            state.nextPrinterType = this.nextPrinter;
            state.notifyAll();
        }
    }
}
