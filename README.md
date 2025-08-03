# Bubbel - Android Social Networking App

[![Android](https://img.shields.io/badge/Android-API%2024+-green.svg)](https://developer.android.com/about/versions/android-14)
[![Kotlin](https://img.shields.io/badge/Kotlin-1.8.0-blue.svg)](https://kotlinlang.org/)
[![MVVM](https://img.shields.io/badge/Architecture-MVVM-orange.svg)](https://developer.android.com/jetpack/guide)
[![Retrofit](https://img.shields.io/badge/Networking-Retrofit-red.svg)](https://square.github.io/retrofit/)

## 📱 Overview

**Bubbel** is a modern Android social networking application built with Kotlin that enables users to discover, join, and interact with clubs and communities. The app features a clean, intuitive interface with real-time user interactions, profile management, and club discovery capabilities.

## ✨ Key Features

- **🔐 User Authentication & Verification**: Secure login/signup with email verification
- **🏠 Home Feed**: Discover and browse clubs with real-time member counts
- **👥 Club Management**: Create, join, and manage clubs with member profiles
- **🔍 Search & Discovery**: Advanced search functionality for clubs and users
- **👤 User Profiles**: Comprehensive user profile management with friend connections
- **💬 Social Features**: Friend connections, messaging, and notifications
- **🎨 Modern UI**: Material Design 3 with smooth animations and transitions

## 🏗️ Architecture & Technologies

### Core Architecture

- **MVVM (Model-View-ViewModel)**: Clean separation of concerns
- **Repository Pattern**: Centralized data management
- **LiveData & ViewModel**: Reactive UI updates
- **Navigation Component**: Seamless screen transitions

### Key Technologies

- **Language**: Kotlin 1.8.0
- **UI Framework**: Android Views with Data Binding
- **Networking**: Retrofit 2.9.0 + OkHttp
- **Serialization**: Kotlinx Serialization + Gson
- **Async Programming**: Kotlin Coroutines
- **Dependency Injection**: Manual DI with ViewModelFactory
- **Navigation**: Android Navigation Component
- **UI Components**: Material Design 3, RecyclerView, ConstraintLayout

### Project Structure

```
app/src/main/java/com/example/bubbel/
├── model/                 # Data models and backend interfaces
│   ├── backend/          # API request/response models
│   ├── Club.kt          # Club data model
│   └── App.kt           # Application class
├── repository/           # Data layer
│   ├── BackendService.kt # API interface
│   ├── RetrofitClient.kt # Network client
│   └── ClubRepository.kt # Data repository
├── view/                # UI layer
│   ├── app/            # Main app screens
│   └── onboarding/     # Authentication screens
├── viewmodel/          # Business logic layer
│   ├── app/           # Main app ViewModels
│   └── onboarding/    # Auth ViewModels
└── utils/             # Utility classes
```

## 🚀 Getting Started

### Prerequisites

- Android Studio Arctic Fox or later
- Android SDK API 24+ (Android 7.0)
- Kotlin 1.8.0+
- JDK 8 or higher

### Installation

1. **Clone the repository**

   ```bash
   git clone https://github.com/yourusername/bubbel-android.git
   cd bubbel-android
   ```

2. **Open in Android Studio**

   - Launch Android Studio
   - Open the project folder
   - Sync Gradle files

3. **Configure Backend**

   - Update the base URL in `RetrofitClient.kt`
   - Ensure your backend API is running

4. **Build and Run**
   ```bash
   ./gradlew assembleDebug
   ```
   Or use Android Studio's "Run" button

### Configuration

- **API Base URL**: Configure in `RetrofitClient.kt`
- **Shared Preferences**: App-level preferences in `App.kt`
- **Network Permissions**: Already configured in `AndroidManifest.xml`

## 📱 Screenshots

_[Add screenshots of your app here]_

## 🔧 API Integration

The app integrates with a comprehensive REST API featuring:

### Authentication Endpoints

- `POST /api/create_user` - User registration
- `POST /api/auth_user` - User login
- `POST /api/verify_account` - Email verification
- `POST /api/deauth_user` - User logout

### Club Management

- `POST /api/create_club` - Create new clubs
- `POST /api/join_club` - Join existing clubs
- `POST /api/get_club_profile` - Fetch club details
- `POST /api/get_club_members` - Get club member list

### Social Features

- `POST /api/add_friend_connection` - Add friends
- `POST /api/get_friend_connections` - Get friend list
- `POST /api/regex_search_users` - Search users
- `POST /api/regex_search_clubs` - Search clubs

### Profile Management

- `POST /api/set_user_profile` - Update user profile
- `POST /api/get_user_profile` - Fetch user profile
- `POST /api/set_club_profile` - Update club profile

## 🎯 Key Implementation Highlights

### 1. Modern Android Architecture

- **MVVM Pattern**: Clean separation between UI, business logic, and data
- **Repository Pattern**: Centralized data access with caching strategies
- **ViewBinding**: Type-safe view access without findViewById

### 2. Network Layer

- **Retrofit Integration**: Type-safe HTTP client with automatic JSON parsing
- **Coroutines**: Asynchronous network calls with structured concurrency
- **Error Handling**: Comprehensive error handling and user feedback

### 3. UI/UX Design

- **Material Design 3**: Modern, accessible interface components
- **RecyclerView**: Efficient list rendering for clubs and users
- **Navigation Component**: Seamless screen transitions with back stack management
- **Custom Animations**: Smooth loading states and transitions

### 4. Data Management

- **SharedPreferences**: Local data persistence for user sessions
- **LiveData**: Reactive UI updates based on data changes
- **ViewModel**: Survives configuration changes and manages UI state

### 5. Security & Performance

- **Network Security**: HTTPS-only communication
- **Memory Management**: Efficient image loading and caching
- **Background Processing**: Coroutines for non-blocking operations

## 🧪 Testing

The project includes comprehensive testing:

- **Unit Tests**: Business logic testing with JUnit
- **Instrumented Tests**: UI testing with Espresso
- **Repository Tests**: Data layer testing

Run tests with:

```bash
./gradlew test          # Unit tests
./gradlew connectedCheck # Instrumented tests
```

## 📊 Performance Metrics

- **Min SDK**: API 24 (Android 7.0)
- **Target SDK**: API 34 (Android 14)
- **Compile SDK**: API 34
- **App Size**: Optimized with ProGuard
- **Memory Usage**: Efficient with RecyclerView and ViewBinding

## 🔮 Future Enhancements

- [ ] **Real-time Messaging**: WebSocket integration for live chat
- [ ] **Push Notifications**: Firebase Cloud Messaging
- [ ] **Image Upload**: Club and profile image management
- [ ] **Offline Support**: Room database for offline functionality
- [ ] **Dark Mode**: Theme switching capability
- [ ] **Internationalization**: Multi-language support

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Developer

**Your Name** - [your.email@example.com](mailto:your.email@example.com)

**LinkedIn**: [Your LinkedIn Profile](https://linkedin.com/in/yourprofile)

**Portfolio**: [Your Portfolio](https://yourportfolio.com)

---

⭐ **Star this repository if you found it helpful!**

_Built with ❤️ using Kotlin and Android Jetpack_
