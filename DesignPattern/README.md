# Design Patterns – Business Scenario Quiz with Answers

### 1. Payment processing

Question: An e-commerce platform supports UPI, credit card and net banking. The customer selects a payment method, and each method has its own payment execution logic. Which pattern best fits?

Answer: Strategy Pattern

Why? Each payment method uses a different algorithm. The customer can choose which algorithm to execute.

- UPI → UPI payment logic
- Credit card → Card payment logic
- Net banking → Net banking logic

Key clue: Interchangeable algorithms.

### 2. Order lifecycle

Question: An order moves through CREATED, CONFIRMED, SHIPPED and DELIVERED. Available operations and their behavior depend on its current status. Which pattern best fits?

Answer: State Pattern

Why? The order behaves differently depending on its current state.

For example:

- CREATED → Can cancel.
- SHIPPED → Cannot cancel normally.
- DELIVERED → Can request a return.

Key clue: Behavior changes based on the object's current state.

### 3. Order notifications

Question: A food delivery platform must notify customers through SMS, email and push notifications whenever an order status changes. New notification subscribers may be added later. Which pattern best fits?

Answer: Observer Pattern

Why? When the order status changes, all registered observers receive notifications.

- SMS notification
- Email notification
- Push notification

Key clue: One object notifies multiple subscribed objects when something changes.

### 4. Loan approval

Question: A loan application passes through eligibility validation, credit score verification, document verification and fraud checks. Each handler can reject the request or pass it to the next handler. Which pattern best fits?

Answer: Chain of Responsibility

Why? The request passes through a sequence of independent handlers.

Eligibility → Credit Score → Document Verification → Fraud Check.

Each handler decides whether to process, reject or forward the request.

Key clue: Sequential handlers passing a request along.

### 5. Invoice creation

Question: A company creates invoices with optional tax details, discounts, shipping information, customer information and multiple line items. It wants readable construction without a constructor containing many parameters. Which pattern best fits?

Answer: Builder Pattern

Why? An invoice has many optional and required fields. Builder lets us construct it step by step.

For example:

```
Invoice invoice = new InvoiceBuilder()
    .setCustomer("Shrinithi")
    .setTax(100)
    .setDiscount(50)
    .setShipping("Chennai")
    .build();
```

Key clue: Complex object construction, especially with optional fields.

### 6. Document editor

Question: A document editor has Save, Undo and Redo actions. Each user action must be represented as an object so it can be stored in history and potentially reversed. Which pattern best fits?

Answer: Command Pattern

Why? Each operation is represented as a separate command object.

- Save → SaveCommand
- Undo → Undo the previous operation
- Redo → Execute the operation again

Key clue: Representing actions as objects, with support for history or undo/redo.

### 7. Banking application

Question: A banking application has different account types. For each type, it must create a matching family of objects: account statement, interest calculator and fee policy. The family must remain compatible with the chosen account type. Which pattern best fits?

Answer: Abstract Factory Pattern

Why? We need to create a family of related objects that belong together.

For example:

- Savings Account Factory → Savings Statement, Savings Interest Calculator, Savings Fee Policy.
- Business Account Factory → Business Statement, Business Interest Calculator, Business Fee Policy.

Key clue: Creating families of related, compatible objects.

### 8. Spotify playlist

Question: A media platform supports Spotify-like playlists. Different playlist types store songs differently, but clients should traverse them sequentially without knowing the underlying collection structure. Which pattern best fits?

Answer: Iterator Pattern

Why? The client can traverse songs without knowing whether they are stored in an ArrayList, LinkedList or another collection.

Key clue: Traverse a collection without exposing its internal structure.

### 9. Report generation

Question: An application offers multiple report-generation workflows. Every report must execute: fetch data, validate data, format data and export data, in that order. Subclasses may customize individual steps but cannot change the overall sequence. Which pattern best fits?

Answer: Template Method Pattern

Why? The parent class defines the overall algorithm, while subclasses customize individual steps.

For example:

- PDF report → PDF formatting and export.
- Excel report → Excel formatting and export.

But the sequence remains fixed.

Key clue: Fixed algorithm structure with customizable steps.

### 10. Ride-booking platform

Question: A ride-booking platform has these requirements:

1. Multiple independent services must be notified when a ride is booked.
2. The ride's permitted operations change between REQUESTED, ACCEPTED and COMPLETED.
3. Customers can choose between different fare-calculation algorithms.

Select every suitable pattern.

Answers: Observer + State + Strategy

| Requirement              | Pattern  | Reason                                    |
| ------------------------ | -------- | ----------------------------------------- |
| Notify multiple services | Observer | Multiple subscribers receive updates      |
| Ride lifecycle           | State    | Behavior changes with ride status         |
| Fare calculation         | Strategy | Different fare algorithms can be selected |

Important: This is a combination of patterns. A real system can use several design patterns together.

## Your revision cheat sheet

| Pattern                 | Remember this clue                        |
| ----------------------- | ----------------------------------------- |
| Simple Factory          | Centralized object creation               |
| Factory Method          | Subclasses decide which object to create  |
| Abstract Factory        | Families of related objects               |
| Builder                 | Complex object, step-by-step construction |
| Singleton               | Only one shared instance                  |
| Strategy                | Choose an algorithm                       |
| State                   | Behavior changes with current state       |
| Observer                | Notify subscribers                        |
| Chain of Responsibility | Pass request through handlers             |
| Template Method         | Fixed workflow, customizable steps        |
| Command                 | Actions represented as objects            |
| Iterator                | Traverse a collection                     |

## The tricky three: Strategy vs State vs Observer

Strategy: What approach should I use?

Example: Calculate fare using Normal, Premium or Surge pricing.

State: What condition am I currently in?

Example: A ride is REQUESTED, ACCEPTED or COMPLETED.

Observer: Who should know when something changes?

Example: Notify customer, driver and payment service when a ride is booked.
