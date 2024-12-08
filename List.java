package CursorList;

import ListElement.ListElement;

public class List {
    private int start = -1;
    private static int space = 0;
    private static final int LENGTH = 50;
    private static Node[] memoryPool;

    static {
        memoryPool = new Node[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            memoryPool[i] = new Node(i+1);
        }
        memoryPool[LENGTH-1] = new Node(-1);
    }

    // Метод для получения предыдущего элемента в списке
    private int GetPrevious(int n){
        int curr = start;
        int tmp = -1;

        while (curr != -1) {
            if (n == curr)
                return tmp;

            tmp = curr;
            curr = memoryPool[curr].next;
        }
        return -1;
    }

    private int GetPreEnd(){
        int curr = start;
        int tmp = -1;

        while(curr != -1){
            tmp = curr;
            curr = memoryPool[curr].next;
        }

        return tmp;
    }

    private Position FindElement(ListElement x) {
        int current = start;

        while (current != -1){
            if (memoryPool[current].data.equals(x)) return new Position(current);
            current = memoryPool[current].next;
        }
        return new Position(-1);
    }

    // проверить существование позиции в первую очередь
    public void Insert(Position p, ListElement x){
        // если вставляем в позицию после последнего
        if(p.position == -1){
            if(space == -1) throw new RuntimeException("Список полон");

            // если список пустой
            if(start == -1){
                start = 0;
                memoryPool[start].data = new ListElement(x);
                space++;
            } else {
                // вставляем в конец списка
                int last = GetPreEnd();
                int nextSpace = memoryPool[space].next;
                memoryPool[space] = new Node(new ListElement(x));
                memoryPool[last].next = space;
                space = nextSpace;
            }
            return;
        }

        if(p.position == start){
            // сохранить ссылку на следующий свободный элемент через memoryPool[space].next
            // скопировать данные из memoryPool[head] в memoryPool[space]
            // установить ссылку на этот элемент в memoryPool[head].next
            // скопировать данные из x в memoryPool[head].letterObject
            // установить space на сохраненное значение
        }

        // проверить не равен ли space -1, если равен то return
        // если не равен, то мы сохраняем ссылку на следующий свободный элемент через memoryPool[space].next
        // копируем данные из memoryPool[p.n] в memoryPool[space]
        // устанавливаем ссылку на memoryPool[space] в memoryPool[p.n].next
        // скопировать данные из x в memoryPool[space].letterObject
        // установить space на сохраненное значение
    }

    public void Delete(Position p){
        // проверяем существование позиции в списке

        if(p.position == -1 || start == -1) return;

        if(p.position == start){
            // в head записываем memoryPool[p.n].next
            // в memoryPool[p.n].next записать space
            // присвоить space значение memoryPool[p.n]
        }

        // удаление последнего элемента
        if(memoryPool[p.position].next == -1){
            // получить предыдущий элемент через getPrevious(p)
            // записать в next предыдущего -1
            // в memoryPool[p.n].next записать space
            // присвоить space значение memoryPool[p.n]
        }

        // получить предыдущий элемент через getPrevious(p)
        // получить следующий элемент через memoryPool[p.n].next
        // записать в next предыдущего следующий элемент
        // в memoryPool[p.n].next записать space
        // присвоить space значение memoryPool[p.n]
    }

    public Position Previous(Position p){
        // проверить позицию на существование через getPrevious(p)
        if(p.position == -1 || p.position == start || p.position > memoryPool.length) throw new RuntimeException("Неверно выбрана позиция");
        int tmp = GetPrevious(p.position);
        if(tmp == -1) throw new RuntimeException("Неверно выбрана позиция");
        return new Position(tmp);
    }

    public ListElement Retrieve(Position p){
        // проверить позицию на существование через getPrevious(p)
        if(GetPrevious(p.position) == -1 || p.position < 0 || p.position > memoryPool.length) throw new RuntimeException("Неверно выбрана позиция");
        if(p.position == start) return memoryPool[start].data;
        return memoryPool[p.position].data;
    }

    public Position Next(Position p){
        // проверить позицию на существование через getPrevious(p)
        if(GetPrevious(p.position) == -1 || p.position > memoryPool.length) throw new RuntimeException("Неверно выбрана позиция");

        if(p.position == start) return new Position(memoryPool[start].next);

        int tmpPrev = GetPrevious(p.position);
        if(tmpPrev == -1) throw new RuntimeException("Неверно выбрана позиция");
        tmpPrev = memoryPool[tmpPrev].next;
        if (tmpPrev == -1) throw new RuntimeException("Неверно выбрана позиция");

        return new Position(memoryPool[tmpPrev].next);
    }

    public Position Locate(ListElement x){
        if(start == -1 || x == null) return null;
        return FindElement(x);
    }



    public Position End() {
        return new Position(-1);
    }

    public Position First() {
        return new Position(start);
    }

    public void MakeNull() {
        start = -1;
    }

    /*public void printList(){
        System.out.println();
        for (int i = 0; i < memoryPool.length; i++) {
            if(memoryPool[i].letterObject==null){
                System.out.printf(i+" "+"null"+" "+ (memoryPool[i].next) +"\n");
            }
            else{
                System.out.printf(i+" "+memoryPool[i].getListElement().nameToString()+" "+memoryPool[i].getListElement().addressToString()+" "+memoryPool[i].getNext()+"\n");
            }
        }
    }*/


}
