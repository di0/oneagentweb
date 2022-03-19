# Purpose

A Proof of Concept that describes the behavior 'keep alive' persistent connection of Camel Framework.

# Expected

When a required connection is opened by the Web Service, it uses one free thread into *connection pool* and when
the connection is closed, it free and returns the thread to connection pool.
