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

Q11. Adapter Pattern

A company has a new payment gateway that accepts XML, but the existing application only understands JSON. You create a class to convert XML requests into the expected JSON interface.

- A. Decorator
- B. Adapter
- C. Bridge
- D. Facade

Answer: B – Adapter

Why? Adapter converts an incompatible interface into one the client expects.

Q12. Decorator Pattern

An e-commerce application allows customers to add cheese, extra toppings and sauces to a pizza dynamically. Each addition increases the price without modifying the original Pizza class.

- A. Proxy
- B. Composite
- C. Decorator
- D. Adapter

Answer: C – Decorator

Why? Decorator wraps an existing object and adds functionality dynamically while preserving its interface.

Q13. Bridge Pattern

A navigation application supports multiple services (Uber Ride, Uber Eats) and multiple map providers (Google Maps, Apple Maps). Both dimensions should evolve independently.

- A. Bridge
- B. Adapter
- C. Facade
- D. Strategy

Answer: A – Bridge

Why? Bridge separates abstraction from implementation so both can vary independently.

Q14. Composite Pattern

An organization has individual employees and departments containing employees or other departments. The application should calculate salary uniformly for an employee or an entire department.

- A. Decorator
- B. Composite
- C. Facade
- D. Proxy

Answer: B – Composite

Why? Composite treats individual objects (leaves) and groups (composites) uniformly through a common interface.

Q15. Facade Pattern

Starting a computer requires CPU initialization, memory loading, GPU setup, disk checks and network initialization. The client should call just one method: `startComputer()`.

- A. Adapter
- B. Proxy
- C. Facade
- D. Bridge

Answer: C – Facade

Why? Facade provides a simplified interface to a complex subsystem.

Q16. Proxy Pattern

An application loads large images from disk. Instead of loading an image immediately, it creates a lightweight object that loads the real image only when `display()` is called.

- A. Decorator
- B. Proxy
- C. Adapter
- D. Composite

Answer: B – Proxy

Why? A Virtual Proxy controls access to the real object and delays its creation/loading until needed.

Q17. Decorator Pattern

A logging feature must be added around an existing service without changing the service's original implementation. The wrapper implements the same interface and delegates calls.

- A. Decorator
- B. Adapter
- C. Bridge
- D. Facade

Answer: A – Decorator

Why? Decorator wraps an object with the same interface and adds behavior. Adapter would change the interface expected by the client.

Q18. Adapter Pattern

A legacy weather service exposes `getWeatherData()`, while the new application expects `fetchWeather()`. A wrapper translates the method call.

- A. Adapter
- B. Proxy
- C. Decorator
- D. Composite

Answer: A – Adapter

Why? Adapter translates one interface into another. The key clue is interface incompatibility.

Q19. Composite Pattern

A document system has a common `FileComponent` interface. A `File` and a `Folder` both implement it, and a `Folder` can contain other folders and files.

- A. Composite
- B. Decorator
- C. Bridge
- D. Facade

Answer: A – Composite

Why? Composite allows leaf objects and containers to be treated uniformly. A folder can contain other folders, creating a tree structure.

Q20. Proxy Pattern

A secure banking application checks whether a user has permission before forwarding a request to the actual account service.

- A. Facade
- B. Decorator
- C. Proxy
- D. Adapter

Answer: C – Proxy

Why? A Protection Proxy controls access to the real object by performing authorization checks.

Got you bro 😂 Same exact format as your structural table.

### Creational Design Patterns
Creational – 5 patterns
Focus: How objects are created.
Simple Factory · Factory Method · Abstract Factory · Builder · Singleton

| Pattern          | Main purpose                           | Key question to ask yourself                                       |
| ---------------- | -------------------------------------- | ------------------------------------------------------------------ |
| Simple Factory   | Centralized object creation            | Is one central class deciding which object to create?              |
| Factory Method   | Delegate object creation to subclasses | Are subclasses deciding which concrete object to create?           |
| Abstract Factory | Create families of related objects     | Am I creating families of compatible objects?                      |
| Builder          | Step-by-step object construction       | Does the object have complex construction or many optional fields? |
| Singleton        | Ensure one shared instance             | Should only one instance of this class exist?                      |

Important distinction:

- Simple Factory centralizes object creation.
- Factory Method delegates creation to subclasses.
- Abstract Factory creates families of related objects.
- Builder constructs complex objects step by step.
- Singleton ensures only one shared instance.

### Behavioral Design Patterns
Behavioral – 7 patterns
Focus: How objects communicate and behave.
Observer · Command · Chain · Iterator · Strategy · Template Method · State

| Pattern                 | Main purpose                     | Key question to ask yourself                                              |
| ----------------------- | -------------------------------- | ------------------------------------------------------------------------- |
| Observer                | Notify subscribers about changes | Should multiple objects get notified when something changes?              |
| Command                 | Encapsulate actions as objects   | Should actions be represented as objects to support undo, redo or queues? |
| Chain of Responsibility | Pass requests through handlers   | Should a request pass through multiple handlers?                          |
| Iterator                | Traverse a collection            | Should I traverse a collection without exposing its internal structure?   |
| Strategy                | Interchangeable algorithms       | Do I need to choose between different algorithms at runtime?              |
| Template Method         | Define a fixed workflow          | Should the parent define the workflow while subclasses customize steps?   |
| State                   | Change behavior based on state   | Should behavior change depending on the object's current state?           |

Important distinction:

- Observer notifies subscribers.
- Command represents actions as objects.
- Chain passes requests through handlers.
- Iterator traverses collections.
- Strategy chooses an algorithm.
- Template Method defines a fixed workflow with customizable steps.
- State changes behavior based on the current state.

### Structural Design Patterns
Structural – 6 patterns
Focus: How objects are connected and organized.
Adapter · Decorator · Bridge · Composite · Facade · Proxy

| Pattern   | Main purpose                            | Key question to ask yourself                                  |
| --------- | --------------------------------------- | ------------------------------------------------------------- |
| Adapter   | Interface conversion                    | Are two incompatible interfaces being connected?              |
| Decorator | Add functionality                       | Am I wrapping an object to add behavior?                      |
| Bridge    | Separate abstraction and implementation | Do two dimensions need to vary independently?                 |
| Composite | Tree structure                          | Am I treating individual objects and groups uniformly?        |
| Facade    | Simplify complexity                     | Am I providing one simple entry point to multiple subsystems? |
| Proxy     | Control access                          | Am I controlling access to a real object?                     |

Important distinction:

- Adapter changes how the client communicates with an object.
- Decorator adds behavior to an object.
- Proxy controls access to an object.
- Facade simplifies interaction with multiple objects.
- Bridge separates two independent dimensions of a design.
- Composite organizes objects into a tree.


## Revision cheat sheet

| Pattern                 | Remember this clue                                                       |
| ----------------------- | ------------------------------------------------------------------------ |
| Simple Factory          | Centralized object creation                                              |
| Factory Method          | Subclasses decide which object to create                                 |
| Abstract Factory        | Families of related objects                                              |
| Builder                 | Complex object, step-by-step construction                                |
| Singleton               | Only one shared instance                                                 |
| Strategy                | Choose an algorithm                                                      |
| State                   | Behavior changes with current state                                      |
| Observer                | Notify subscribers                                                       |
| Chain of Responsibility | Pass request through handlers                                            |
| Template Method         | Fixed workflow, customizable steps                                       |
| Command                 | Actions represented as objects                                           |
| Iterator                | Traverse a collection                                                    |
| Adapter                 | Makes incompatible interfaces work together                              |
| Decorator               | Adds new functionality dynamically by wrapping an object                 |
| Bridge                  | Separates abstraction from implementation so both can vary independently |
| Composite               | Treats individual objects and groups uniformly                           |
| Facade                  | Provides a simple interface to a complex subsystem                       |
| Proxy                   | Controls access to another object                                        |

## Tricky

## 1. Strategy vs State vs Observer-The tricky three
Strategy: What approach should I use?

Example: Calculate fare using Normal, Premium or Surge pricing.

State: What condition am I currently in?

Example: A ride is REQUESTED, ACCEPTED or COMPLETED.

Observer: Who should know when something changes?

Example: Notify customer, driver and payment service when a ride is booked.

Bro, YES! 🔥 There are several patterns that look similar in interviews. These are worth learning because interviewers deliberately create scenarios where two or three patterns seem correct.

Let's make a tricky pattern comparison cheat sheet.

| Pattern  | Think this way                          | Example                                                            |
| -------- | --------------------------------------- | ------------------------------------------------------------------ |
| Strategy | What approach should I use?             | Calculate fare using Normal, Premium or Surge pricing.             |
| State    | What condition am I currently in?       | A ride is REQUESTED, ACCEPTED or COMPLETED.                        |
| Observer | Who should know when something changes? | Notify customer, driver and payment service when a ride is booked. |

## 2. Simple Factory vs Factory Method vs Abstract Factory

| Pattern          | Think this way                                   | Example                                                                                             |
| ---------------- | ------------------------------------------------ | --------------------------------------------------------------------------------------------------- |
| Simple Factory   | Who creates the object centrally?                | NotificationFactory creates Email or SMS notification.                                              |
| Factory Method   | Which subclass decides what to create?           | EmailNotificationCreator creates EmailNotification; SMSNotificationCreator creates SMSNotification. |
| Abstract Factory | Which family of related objects should I create? | AWS factory creates AWS storage, database and queue implementations.                                |

## 3. Adapter vs Decorator vs Proxy

| Pattern   | Think this way                                       | Example                                                             |
| --------- | ---------------------------------------------------- | ------------------------------------------------------------------- |
| Adapter   | How do I make incompatible interfaces work together? | Convert XML input to the JSON interface expected by an application. |
| Decorator | How do I add extra functionality?                    | Add cheese and toppings to a pizza dynamically.                     |
| Proxy     | How do I control access to an object?                | Load an image only when the user requests it.                       |

## 4. Facade vs Adapter vs Proxy

| Pattern | Think this way                                | Example                                                          |
| ------- | --------------------------------------------- | ---------------------------------------------------------------- |
| Facade  | How do I simplify a complex subsystem?        | One `startComputer()` method initializes CPU, memory and GPU.    |
| Adapter | How do I convert an incompatible interface?   | Make a legacy payment gateway work with a new payment interface. |
| Proxy   | How do I control access to the actual object? | Check user permissions before accessing a bank account.          |

## 5. Decorator vs Composite

| Pattern   | Think this way                                | Example                                    |
| --------- | --------------------------------------------- | ------------------------------------------ |
| Decorator | Add responsibilities to an individual object. | Add cheese and toppings to a pizza.        |
| Composite | Combine individual objects into groups.       | A folder contains files and other folders. |

Both use recursive wrapping/tree-like structures in some implementations, but their intentions differ.

## 6. Command vs Strategy

| Pattern  | Think this way                  | Example                                        |
| -------- | ------------------------------- | ---------------------------------------------- |
| Command  | What action should be executed? | Open, Save, Undo in a document editor.         |
| Strategy | Which algorithm should be used? | Choose UPI, Card or Wallet payment processing. |

Remember: Command represents a request as an object; Strategy represents an interchangeable algorithm.

## 7. Template Method vs Strategy

| Pattern         | Think this way                                        | Example                                          |
| --------------- | ----------------------------------------------------- | ------------------------------------------------ |
| Template Method | What steps must always happen in this order?          | Order processing: validate → payment → delivery. |
| Strategy        | Which implementation of an algorithm should I choose? | Choose different payment calculation algorithms. |

Template Method commonly uses inheritance; Strategy commonly uses composition.

## 8. Chain of Responsibility vs Decorator

| Pattern                 | Think this way                               | Example                                           |
| ----------------------- | -------------------------------------------- | ------------------------------------------------- |
| Chain of Responsibility | Who should handle this request?              | Authentication → Authorization → Validation.      |
| Decorator               | What extra behavior should wrap this object? | Logging → Caching → Compression around a service. |

## 9. Builder vs Factory

| Pattern | Think this way                           | Example                                                           |
| ------- | ---------------------------------------- | ----------------------------------------------------------------- |
| Builder | How should I construct a complex object? | Create a user with optional name, email, address and preferences. |
| Factory | Which object should I create?            | Create EmailNotification or SMSNotification.                      |

## 10. Iterator vs Composite

| Pattern   | Think this way                                    | Example                              |
| --------- | ------------------------------------------------- | ------------------------------------ |
| Iterator  | How do I traverse elements?                       | Navigate through a Spotify playlist. |
| Composite | How do I represent individual objects and groups? | Represent files and nested folders.  |

## The ultimate interview cheat sheet

When reading a business requirement, ask yourself:

| If the requirement says...              | Think of...             |
| --------------------------------------- | ----------------------- |
| Choose between different algorithms     | Strategy                |
| Behavior changes based on lifecycle     | State                   |
| Notify multiple subscribers             | Observer                |
| Represent actions, undo/redo            | Command                 |
| Pass through multiple handlers          | Chain of Responsibility |
| Fixed sequence of steps                 | Template Method         |
| Traverse a collection                   | Iterator                |
| Centralized object creation             | Simple Factory          |
| Subclasses decide object creation       | Factory Method          |
| Families of related objects             | Abstract Factory        |
| Complex object construction             | Builder                 |
| One shared instance                     | Singleton               |
| Incompatible interfaces                 | Adapter                 |
| Add functionality dynamically           | Decorator               |
| Separate abstraction and implementation | Bridge                  |
| Individual objects and groups           | Composite               |
| Simplify complex subsystems             | Facade                  |
| Control access to an object             | Proxy                   |