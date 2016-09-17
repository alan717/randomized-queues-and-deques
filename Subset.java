
import edu.princeton.cs.algs4.StdIn;
import java.util.Random;

/*
 * Copyright (C) 2016 Michael <GrubenM@GMail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * Takes a command-line integer k; reads in a sequence of N strings from
 * standard input using StdIn.readString(); and prints out exactly k of them,
 * uniformly at random. Each item from the sequence can be printed out at most
 * once. You may assume that 0 ≤ k ≤ n, where N is the number of string on
 * standard input.
 * @author Michael <GrubenM@GMail.com>
 */
public class Subset {
    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        int k = Integer.parseInt(args[0]);
        while (!StdIn.isEmpty()) rq.enqueue(StdIn.readString());
        for (int i = 0; i < k; i++) System.out.println(rq.dequeue());
    }
}
