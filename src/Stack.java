public class Stack {
        private int maxSize;
        private int[] stack;
        private int top;

        public Stack(int size){
            this.maxSize = size;
            this.stack = new int[this.maxSize];
            this.top = -1;
        }
//  3. Реализовать расширение массива в стеке при заполнении стека.
        public void push(int i){
            if (this.top == this.maxSize-1) {
                int[] stack1 = new int[this.maxSize + 1 + this.maxSize / 2];
                for (int k = 0; k < this.maxSize; k++)
                    stack1[k] = this.stack[k];
                this.stack = null;

                this.stack = stack1;
                this.maxSize = this.stack.length;
            }
            this.stack[++this.top] = i;
        }

        public int pop(){
            return this.stack[this.top--];
        }

        public int peek(){
            return this.stack[this.top];
        }

        public boolean isEmpty(){
            return (this.top == -1);
        }

        public boolean isFull(){
            return (this.top == this.maxSize-1);
        }
}
