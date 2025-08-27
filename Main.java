package neuron;

import neuron.Neuron;

public class Main {
    public static void main(String[] args) {
        // دو نورون ورودی
        Neuron input1 = new Neuron(1.0f, 0.0f);
        Neuron input2 = new Neuron(1.0f, 0.0f);

        // نورون لایه پنهان
        Neuron hidden = new Neuron(1.5f, 2.0f);

        // نورون خروجی
        Neuron output = new Neuron(2.0f, 3.0f);

        // اتصال نورون‌ها
        hidden.addInput(input1);
        hidden.addInput(input2);
        output.addInput(hidden);

        // مقداردهی ورودی‌ها
        input1.setTotal(1.0f);
        input2.setTotal(2.0f);

        // محاسبه خروجی شبکه
        System.out.println(output.fire());

    }
}
